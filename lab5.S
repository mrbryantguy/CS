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
;;  SINCe our setup utilizes PORTB and PORTB, then we need to main
;;   simulataneous vectors for all of the segment sequences that are neededed
;;
;; main rOUTine does
;;   setup_ports once
;; 
;;   C code to do the following

;;   segment=0
;;   digit=9
;;   display_segment();; will display 9 on segment 0, for example
  
  .data
  .macro pushall
  push r16
  push r17
  push r18
  push r19
  push r20
  push r21
  push r22
  push r23
  push r24
  push r25
  push r26
  push r27
  push r28
  push r29
  push r30
  push r31
  .endm ; of pushall

  .macro popall
  pop r31
  pop r30
  pop r29
  pop r28
  pop r27
  pop r26
  pop r25
  pop r24
  pop r23
  pop r22
  pop r21
  pop r20
  pop r19
  pop r18
  pop r17
  pop r16
  .endm ; of popall
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
    .byte  0b11111100,0b00011000,0b01101100,0b00111100,0b10011000,0b10110100,0b11110100,0b00011100,0b11111100, 0b10111100
    ;;     0          1          2          3          4          5          6          7          8           9

  
  .comm segment, 1 ;; the common name for segment
  .comm digit, 1 ;; the digit into our sequences
  .global segment, digit

  

# --------
  .text
  .global setup_ports
  .global display_segment

  

setup_ports:  ;; rOUTine to set the ports into OUTput mode

  LDI  r16, 0x1F // for digital pins 8-12
  OUT  0x04, r16 // DDRB
  OUT  0x05, r16 // PORTB

  LDI  r16, 0xFC // for digital pins 2-7
  OUT  0x0A, r16 // DDRD
  OUT  0x0B, r16 // PORTD
  
  ret ;; of setup_ports



display_segment:  ;;  main entry point for setting the segment
   pushall

   ;; the goal is the use "digit" and "segment" to find the values that need to be sent to PORTB and PORT D 

   LDI R31, hi8(segment_table) ; initialize high byte of Z
   LDI R30, lo8(segment_table) ; initialize low byte of Z
   LDI R29, hi8(portb_table) ; initialize high byte of Y
   LDI R28, lo8(portb_table) ; initialize low byte of Y
   LDI R27, hi8(portd_table) ; initialize high byte of X
   LDI R26, lo8(portd_table) ; initialize low byte of X
   LDI  r23, 0 // for segcheck
   LDI r19, 0 // for digcheck

digcheck:
   LD  r20, X+ ;; portd table
   LD  r21, Y+ ;; portb for 8
   LDS  r17, digit ;; digit to be outputted

   CP  r17, r19 ;; compare the digit to r19
   BREQ  segcheck ;; if equal, then we must compare the segment
   INC  r19
   JMP digcheck

segcheck:
    
   LD  r22, z+ ;; segment table
   LDS  r16, segment ;; segment from C
   
   CP  r16, r23
   BREQ  lightup
   INC  r23
   jmp  segcheck

lightup:
   ADD  r22, r21
   OUT  0x05, r22 ;; out for PORTB (8-15) segment
   OUT  0x0B, r20 ;; out for PORTD (0-7)  number
   popall
   ret
