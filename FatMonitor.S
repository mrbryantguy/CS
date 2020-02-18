// Bryant Hernandez

#
# Global data (gender, age, and fat)
#
    .data
    .comm gender, 1
    .global gender
    .comm age, 1
    .global age
    .comm fat, 1
    .global fat
    .comm bvector, 1
    .global bvector

#
# Program code (lightup function)
#
    .text
    .global lightup
    
lightup:

  
  LDS  r16, gender
  CPI  r16, 0x01
  BREQ  female

  ;; we are male
  JMP male

female:
    lds r17, age ;; load age

    cpi  r17, 40
    brlo  f20
    cpi  r17, 60
    brlo  f40
    cpi  r17, 80
    brlo  f60
    ;; we are 80 or older
    ldi  r18, 0b0
    sts  bvector, r18
    jmp lights

f20:    ;; female 20 to 40
    lds r19, fat  ;; load fat

    CPI  R19, 21
    BRLO  m20low  ;; branch to handle low fat m20
    CPI  R19, 33
    BRLO  m20normal
    CPI  R19, 39
    BRLO  m20high
    ;; we are extra fat
    ldi  r21, 0  ;; don't BLINK when extra fat
    LDI  R18, 0b00110001  ;; (all lights)
    sts  bvector,r18
    jmp  lights

f40:    ;; female 40 to 60
    lds r19, fat  ;; load fat

    CPI  R19, 23
    BRLO  m20low  ;; branch to handle low fat m20
    CPI  R19, 34
    BRLO  m20normal
    CPI  R19, 40
    BRLO  m20high
    ;; we are extra fat
    ldi  r21, 0  ;; don't BLINK when extra fat
    LDI  R18, 0b00110001  ;; (all lights)
    jmp  lights

f60:    ;; female 60 to 80
    lds r19, fat  ;; load fat

    CPI  R19, 24
    BRLO  m20low  ;; branch to handle low fat m20
    CPI  R19, 36
    BRLO  m20normal
    CPI  R19, 42
    BRLO  m20high
    ;; we are extra fat
    ldi  r21, 0  ;; don't BLINK when extra fat
    LDI  R18, 0b00110001  ;; (all lights)
    jmp  lights

male:
    LDS  r17, age  ;; load age

    CPI  r17, 40
    BRLO  m20
    CPI  r17, 60
    BRLO  m40
    CPI  r17, 80
    BRLO  m60
    ;; we are 80 or older
    ldi  r18, 0b0
    sts  bvector, r18
    jmp lights


m20:    ;; male 20 to 40

    lds r19, fat  ;; load fat

    CPI  R19, 8  
    BRLO  m20low  ;; branch to handle low fat m20
    CPI  R19, 20
    BRLO  m20normal
    CPI  R19, 25
    BRLO  m20high
    ;; we are extra fat
    ldi  r21, 0  ;; don't BLINK when extra fat
    LDI  R18, 0b00110001  ;; (all lights)
    jmp  lights

m20low:   ;; we are male 20 to 40 low fat (blue light)
    ldi  r18, 0b00100000
    sts  bvector, r18
    ldi    r21, 30    ;; loads the number of blinks
    jmp  lights
    
m20normal:    ;; we are male 20 to 40 normal fat (green light)
    ldi  r18, 0b00010000
    sts  bvector, r18
    ldi    r21, 30
    jmp lights

m20high:    ;; we are male 20 to 40 high fat (red light)
    ldi  r18, 0b00000001
    sts  bvector, r18
    ldi  r21, 30
    jmp  lights

m40:    ;; male 40 to 60

    lds  r19, fat  ;; load fat
    
    CPI  R19, 11  
    BRLO  m20low  ;; branch to m20
    CPI  R19, 22
    BRLO  m20normal
    CPI  R19, 28
    BRLO  m20high
    ;; we are extra fat
    LDI  r21, 0
    LDI  R18, 0b00110001
    jmp lights

m60:    ;; male 60 to 80

    lds  r19, fat  ;; load fat

    CPI  R19, 13  
    BRLO  m20low  ;; branch to m20
    CPI  R19, 25
    BRLO  m20normal
    CPI  R19, 30
    BRLO  m20high
    ;; we are extra fat
    LDI  r21, 0
    LDI  R18, 0b00110001
    jmp lights
    
lights:
      cpi  r21, 1
      brlo  noblink
      lds  r18, bvector
      out  0x04, r18  ;; I/O of DDRB, sets the direction
all:  lds  r18, bvector
      out  0x05, r18  ;; I/O of PORTB, sends flow
      ldi    r19, 0xff
dl1:  ldi    r20, 0xff
dl2:  nop
      nop
      nop
      nop
      dec    r20
      brne   dl2
      dec    r19
      brne   dl1
      ldi    r18, 0x00
      out    0x05, r18
      ldi    r19, 0xff
dl3:  ldi    r20, 0xff
dl4:  nop
      nop
      nop
      nop
      dec    r20
      brne   dl4
      dec    r19
      brne   dl3
      dec    r22
      dec    r21
      brne   all
      ret

noblink:
    out  0x04, r18
    out  0x05, r18
    ret
