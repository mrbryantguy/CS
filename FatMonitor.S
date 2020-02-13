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

#
# Program code (lightup function)
#
    .text
    .global lightup
lightup:

  
  lds  R16, gender
  CPI  R16, 1
  BRLO  female

  ;; we are male
  jmp male

female:

    lds R17, age
    
    CPI  R17, 40
    BRMI  f20  ;; branch to handle f20s
    CPI  R17, 60
    BRMI  f40
    CPI  R17, 80
    BRMI  f60

    ;; we are over 79
    ldi  r18, 0
    sts bvector, r18
    jmp lights

f20:    ;; female 20 to 39

    lds r19, fat

    ;; handle very high fat
    CPI  R19, 21
    BRMI  f20low ;; branch to handle 
    CPI  R19, 33
    BRMI  f20normal
    CPI  R19, 39
    BRMI  f20high
    ;; we are extra fat
    ldi  r18, 0  ;; don't blink when extra fat
    STS  BLINK, r18
    LDI  R18, 0b00110001
    STS  BVECTOR, R18
    jmp  lights

f20low:   ;; we are female 20 to 39 low fat
    ldi  r18, 0b00100000
    sts  BVECTOR, r18
    jmp  lights
    
f20normal:    ;; we are female 20 to 39 normal fat
    ldi  r18, 0b00010000
    sts  BVECTOR, r18
    jmp lights

f20high:    ;; we are female 20 to 39 high fat
    ldi  r18, 0b00110001
    sts  BVECTOR, r18
    jmp  lights

f40:    ;; female 40 to 59

    lds r19, fat

    ;; handle very high fat
    CPI  R19, 23
    BRMI  f40low ;; branch to handle 
    CPI  R19, 34
    BRMI  f40normal
    CPI  R19, 40
    BRMI  f40high
    ;; we are extra fat
    ldi  r18, 0  ;; don't blink when extra fat
    STS  BLINK, r18
    LDI  R18, 0b00110001
    STS  BVECTOR, R18
    jmp  lights

f40low:   ;; we are female 40 to 59 low fat
    ldi  r18, 0b00100000
    sts  BVECTOR, r18
    jmp  lights
    
f40normal:    ;; we are female 40 to 59 normal fat
    ldi  r18, 0b00010000
    sts  BVECTOR, r18
    jmp lights

f40high:    ;; we are female 40 to 59 high fat
    ldi  r18, 0b00110001
    sts  BVECTOR, r18
    jmp  lights

f60:    ;; female 60 to 79

    lds r19, fat

    ;; handle very high fat
    CPI  R19, 24
    BRMI  f60low ;; branch to handle 
    CPI  R19, 36
    BRMI  f60normal
    CPI  R19, 42
    BRMI  f60high
    ;; we are extra fat
    ldi  r18, 0  ;; don't blink when extra fat
    STS  BLINK, r18
    LDI  R18, 0b00110001
    STS  BVECTOR, R18
    jmp  lights

f60low:   ;; we are female 60 to 79 low fat
    ldi  r18, 0b00100000
    sts  BVECTOR, r18
    jmp  lights
    
f60normal:    ;; we are female 60 to 79 normal fat
    ldi  r18, 0b00010000
    sts  BVECTOR, r18
    jmp lights

f60high:    ;; we are female 60 to 79 high fat
    ldi  r18, 0b00110001
    sts  BVECTOR, r18
    jmp  lights

m20:    ;; male 20 to 39

    lds r19, fat

    ;; handle very high fat
    CPI  R19, 8
    BRMI  m20low ;; branch to handle 
    CPI  R19, 20
    BRMI  m20normal
    CPI  R19, 25
    BRMI  m20high
    ;; we are extra fat
    ldi  r18, 0  ;; don't blink when extra fat
    STS  BLINK, r18
    LDI  R18, 0b00110001
    STS  BVECTOR, R18
    jmp  lights

m20low:   ;; we are male 20 to 39 low fat
    ldi  r18, 0b00100000
    sts  BVECTOR, r18
    jmp  lights
    
m20normal:    ;; we are male 20 to 39 normal fat
    ldi  r18, 0b00010000
    sts  BVECTOR, r18
    jmp lights

m20high:    ;; we are male 20 to 39 high fat
    ldi  r18, 0b00110001
    sts  BVECTOR, r18
    jmp  lights

m40:    ;; male 40 to 59

    lds r19, fat

    ;; handle very high fat
    CPI  R19, 11
    BRMI  m40low ;; branch to handle 
    CPI  R19, 22
    BRMI  m40normal
    CPI  R19, 28
    BRMI  m40high
    ;; we are extra fat
    ldi  r18, 0  ;; don't blink when extra fat
    STS  BLINK, r18
    LDI  R18, 0b00110001
    STS  BVECTOR, R18
    jmp  lights

m40low:   ;; we are male 40 to 59 low fat
    ldi  r18, 0b00100000
    sts  BVECTOR, r18
    jmp  lights
    
m40normal:    ;; we are male 40 to 59 normal fat
    ldi  r18, 0b00010000
    sts  BVECTOR, r18
    jmp lights

m40high:    ;; we are male 40 to 59 high fat
    ldi  r18, 0b00110001
    sts  BVECTOR, r18
    jmp  lights

m60:    ;; male 60 to 79

    lds r19, fat

    ;; handle very high fat
    CPI  R19, 13
    BRMI  m60low ;; branch to handle 
    CPI  R19, 25
    BRMI  m60normal
    CPI  R19, 30
    BRMI  m60high
    ;; we are extra fat
    ldi  r18, 0  ;; don't blink when extra fat
    STS  BLINK, r18
    LDI  R18, 0b00110001
    STS  BVECTOR, R18
    jmp  lights

m60low:   ;; we are male 60 to 79 low fat
    ldi  r18, 0b00100000
    sts  BVECTOR, r18
    jmp  lights
    
m60normal:    ;; we are male 60 to 79 normal fat
    ldi  r18, 0b00010000
    sts  BVECTOR, r18
    jmp lights

m60high:    ;; we are male 60 to 79 high fat
    ldi  r18, 0b00110001
    sts  BVECTOR, r18
    jmp  lights
    
lights:
  out 0x04, R18   ; 0x04 is I/O address of DDRB
  out 0x05, R18   ; 0x05 is I/O address of PORTB
  ret
