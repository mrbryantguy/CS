;;

;;  AVR code to do the function of the 4  x 7 segment display of Lab 5
;;
;;
;;   Bryant Hernandez
;;    CS 273
;;    Semester Spring , 2020
;;
;;  The basic algorithm is to have the main loop
;; set some shared variable values
;;  we then use simulataneous arrays (vectors)
;;  to figure out which segment is desired 
;;; and which sequence is needed
;;
;;  Since our setup utilizes PORTB and PORTB, then we need to main
;;   simulataneous vectors for all of the segment sequences that are neededed
;;
;; main routine does
;;   setup_ports once
;; 
;;   C code to do the following

;;   segment=0
;;   digit=9
;;   display_segment();; will display 9 on segment 0, for example
;;  
  .data
  .size segment_table, 4
  .size portb_table, 10
  .size portd_table, 10
  
segment_table:  #binary for seting input on PORTB for segment select (8-15)
    .byte 0b00011100, 0b00011010, 0b00010110, 0b00001110
    ;;    Segment 0   Segment 1   Segment 2   Segment 3
portb_table:  # list of binary sequences for setting port B to be ORed with segment table ite
    .byte  0,0,1,1,1,1,1,0,1,1
    ;;     0,1,2,3,4,5,6,7,8,9
portd_table: # list of binary sequences for setting port D. (0-7)
    .byte  0b1111100,0b00011000,0b01101100,0b00111100,0b10011000,0b10110100,0b11110100,0b00011100,0b11111100, 0b10111100
    ;;     0         1          2          3          4          5          6          7          8           9
segmentv: .byte 1

  
  .comm segment, 1 ;; the common name for segment
  .comm digit, 1 ;; the digit into our sequences
  .global segment, digit

  

# --------
  .text
  .global setup_ports
  .global display_segment



setup_ports:  ;; routine to set the ports into output mode

  ldi  r16, 0x1F // for digital pins 8-12
  out  0x04, r16 // DDRB
  out  0x05, r16 // PORTB

  ldi  r16, 0xFC // for digital pins 2-7
  out  0x0A, r16 // DDRD
  out  0x0B, r16 // PORTD
  
  ret ;; of setup_ports



display_segment:  ;;  main entry point for setting the segment

   ;; the goal is the use "digit" and "segment" to find the values that need to be sent to PORTB and PORT D 

   //LDI R31, hi8(segment_table) ; initialize high byte of Z
   //LDI R30, lo8(segment_table) ; initialize low byte of Z
   LDI R29, hi8(portb_table) ; initialize high byte of Y
   LDI R28, lo8(portb_table) ; initialize low byte of Y
   LDI R27, hi8(portd_table) ; initialize high byte of X
   LDI R26, lo8(portd_table) ; initialize low byte of X

   digcheck:
     ld  r20, x+ ;; portd table
     ld  r21, y+ ;; portb for 8
     // ld  r22, z+ ;; segment table
     lds  r17, digit
     lds  r16, segment

     cpi  r17, 0
     breq  lightnum
     jmp digcheck
     cpi  r17, 1
     breq  lightnum
     jmp digcheck
     cpi  r17, 2
     breq  lightnum
     jmp digcheck
     cpi  r17, 3
     breq  lightnum
     jmp digcheck
     cpi  r17, 4
     breq  lightnum
     jmp digcheck
     cpi  r17, 5
     breq  lightnum
     jmp digcheck
     cpi  r17, 6
     breq  lightnum
     jmp digcheck
     cpi  r17, 7
     breq  lightnum
     jmp digcheck
     cpi  r17, 8
     breq  lightnum
     jmp digcheck
     cpi  r17, 9
     breq  lightnum

lightnum:
     out  0x0B, r20 ;; out for PORTD
     cpi  r16, 0
     BREQ  seg0
     cpi  r16, 1
     BREQ  seg1
     cpi  r16, 2
     BREQ  seg2
     jmp  seg3
     ret

seg0:
    ldi  r16, 0b00011100
    add  r16, r21
    out  0x05, r16
    ret

seg1:
    ldi  r16, 0b00011010
    add  r16, r21
    out  0x05, r16
    ret

seg2:
    ldi  r16, 0b00010110
    add  r16, r21
    out  0x05, r16
    ret

seg3:
    ldi  r16, 0b00001110
    add  r16, r21
    out  0x05, r16
    ret
