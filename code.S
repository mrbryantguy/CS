    .data
    .comm segment, 1
    .global segment
    
    .text
    .global outputf
    .global selectseg
    
outputf:

    ldi  r16, 0x1F // for digital pins 8-12
    out  0x04, r16 // DDRB
    out  0x05, r16 // PORTB
    
    ldi  r16, 0xFC // for digital pins 2-7
    out  0x0A, r16 // DDRD
    out  0x0B, r16 // PORTD
    ret

// uses a shared global variable to select the segment
// essentially turns on and off the two ports that drive the selection of each segment 
selectseg:

    lds  r16, segment
    cpi  r16, 0
    BREQ  seg0
    cpi  r16, 1
    BREQ  seg1
    cpi  r16, 2
    BREQ  seg2
    call  seg3
    ret

seg0:
    ldi  r16, 0b00011101
    out  0x05, r16
    ret

seg1:
    ldi  r16, 0b00011011
    out  0x05, r16
    ret

seg2:
    ldi  r16, 0b00010111
    out  0x05, r16
    ret

seg3:
    ldi  r16, 0b00001111
    out  0x05, r16
    ret
