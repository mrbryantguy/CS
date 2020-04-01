// Program name : lab6.S
// Purpose      : AVR code to display digits obtained from the list or letters obtained from the global data array
// Name         : Bryant Hernandez
// Date         : 03/31/2020
// Input        : Input and data array from INO file
// Output       : Result from encodeDigit is stored in the result shared variable
// Assumptions  : Assume correct data is coming in from the shared global variables and array.
//
// Test results:
//    The program runs as expected, humidity and temperature and displayed correctly; when I blow on the sensor humidity rises from about
//    32% to 55%
// Answers to questions if on the lab:
//    How do you run power through the breadboard.
//    Wiring was pretty simple, 5V went to the + and ground went to the -, the rest of that strip can be used to power the two devices
// What you learned?
//    Learned how to wire my DHT1 and TM1637 components using male-female wires I had not used before.
//    Got much more comfortable using shared variables and arrays in my program as well as using a rotation such as LSR

#
# I2C interface is wired to Arduino PORTB bits
# 4 and 5, with 4 being data and 5 being clock,
# so these symbols give us the values needed
#
      .set PORTB,0x05
      .set DDIRB,0x04
      .set SDA,0 ;; digital pin 8 
      .set SCL,1 ;; digital pin 9 

#
# I2C addresses of the components:
#  7-segment LED: 0x40
#   Position: 0xC0 + 4 bytes
#   Brightness: 0x8a
#  
#  We will be using pull up resistors which means that we have opposite logic about
#  When the value we set is the opposite that is being read by the display
#  This code is based heavily off of the TM1637Display.cpp code found on Github

#
# Global data
#
#   
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

digits: // binary strings for digits 
        //      0           1           2           3            4          5           6           7            8          9
  .byte 0b00111111, 0b00000110, 0b01011011, 0b01001111, 0b01100110, 0b01101101, 0b01111101, 0b00000111, 0b01111111, 0b01101111
  
    .comm data, 4
    .global data
    .comm input, 1
    .global input
    .comm result, 1
    .global result

    
# external symbol (delay function)
    .extern delay

#
# Program code
#
     .text
     .global display_symbol
     .global sendBrightness
     .global  stopBit
     .global  startBit
     .global encodeDigit
     
display_symbol: 
      call setupport ;; set the port to the correct IO direction
      
      call  sendAddress     ; send 7SEG address 
      call  sendPos        ; send instruction for each segment
      call  sendBrightness  ; set brightness
      ret                   ; all done, return to main program!

setupport: ;; set up the port for TM1637
       # set pins to input mode
       cbi   DDIRB,SDA
       cbi   DDIRB,SCL
       cbi   PORTB, SDA
       cbi   PORTB, SCL  ;; this means data and clock are high
       call  delay1          ; wait to make sure PORTB ready
       ret ;; of setupport
#
# Delay for 1 millisecond (saves/restores r18-r20)
#
delay1:
      push r18
      push r19
      push r20
      ldi  r22, 1
      ldi  r23, 0
      ldi  r24, 0
      ldi  r25, 0
      call delay
      pop  r20
      pop  r19
      pop  r18
      ret

#
# I2C startbit: a high-to-low transition on SDA while clock is high
#
startBit:
      sbi   DDIRB,SDA    ; set data bit high, maklng data line go low
      call  delay1       ; leave clock high long enough
      ret

#
# I2C stopit: a low-to-high transition on SDA while clock is high
#
stopBit:
      sbi   DDIRB,SDA    ;
      call delay1
      cbi   PORTB,SCL    ; set clock high
      cbi   DDIRB, SCL    ;  when we turn off one we have to take care of direction
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SDA    ; bring up SDA while clock is high
      cbi   DDIRB, SDA     ; when we clear port we set input mode
      call  delay1       ; keep clock high for a while
      ret

#
# I2C 1 bit transmission: SDA high while clock is high
# 
oneBit:
      sbi   DDIRB,SCL    ; clock goes down due to pull-up 
      call delay1
      cbi   PORTB,SDA    ; A clear writes a 1 to the device
      cbi   DDIRB, SDA
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SCL    ; finally bring clock low
      cbi   DDIRB, SCL
      call  delay1       ; leave clock low for long enough
      ret

#
# I2C 0 bit transmission: SDA low while clock is high
# 
zeroBit:
      sbi   DDIRB,SCL    ; clock goes down due to pull-up 
      call delay1
      sbi   DDIRB,SDA    ; A clear writes a 1 to the device
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SCL    ; finally bring clock low
      cbi   DDIRB, SCL
      call  delay1       ; leave clock low for long enough
      ret

ack:  sbi DDIRB, SCL
      cbi PORTB, SDA
      cbi DDIRB, SDA
      call delay1
      cbi PORTB, SCL
      cbi DDIRB, SCL
      call delay1

      sbis PORTB, SDA  ;; skip if we have a 0 in this slot as per the arduino code
      sbi DDIRB, SDA
      call delay1
      
      sbi DDIRB, SCL
      call delay1
      ret
#
# I2C LED address transmission: must transmit the byte value 0x40
#
sendAddress:

      LDI  R18, 0x40
      call  startBit
      call  sendByte
      call  stopBit
      ret

#
# Position should be 0xC0 
#  - 
#
sendPos:
      pushall
      LDI  R31, hi8(data) ; initialize high byte of Z
      LDI  r30, lo8(data) ; initialize low byte of Z
      ldi r16, 4 // do this 4 times, one for every byte of data
      LDI R18, 0xC0
      call startBit
      call sendByte

z:
      ld  r18, Z+ // load data[i]
      call sendByte
      dec r16
      brne z
      
      call stopBit
      popall
      ret

#
# Command Brightness 0x89
#  - in binary, 01001010
#
sendBrightness:

      LDI  R18, 0x89
      call startBit
      call sendByte
      call stopBit
      ret

#
# Transmit a byte that will display a symbol
#  - you must figure it out!
#
show_one_symbol: ;; you should not have to call this other than testing
// 7 segment display
      call  oneBit // A
      call  zeroBit // B
      call  zeroBit // C
      call  oneBit // D
      call  oneBit // E
      call  oneBit // F
      call  oneBit // G
      call  zeroBit // :
      call  ack
      ret

#  A simple routine which assumes R18 has the Byte in question
#  We loop through the bits of the R18 (this makes R18 not usable
#  and sends the appropriate zero or one bit. We send by least significant bit
#  We then send an ACK at the end


 sendByte:
       pushall
       ldi r16, 8
 loop:
      // get the least significant digit of R18
      lsr R18
      brcc  Zero
      jmp One

Zero:
      call zeroBit
      jmp  rest
      
One:
      call oneBit
      
rest:
      dec r16
      brne loop
      call ack
      popall
      ret

encodeDigit: 

      pushall
      LDI  R29, hi8(digits) ; initialize high byte of Y
      LDI  R28, lo8(digits) ; initialize low byte of Y
      lds  r16, input // number to be displayed

l1:
      ld r17, Y+
      cpi r16, 0
      breq l2
      dec r16
      rjmp l1
l2:
      sts result, r17

      popall
      ret
