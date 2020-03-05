/*
  Showing number 0-9 on a Common Anode 7-segment LED display
  Displays the numbers 0-9 on the display, with one second inbetween.
    A
   ---
F |   | B
  | G |
   ---
E |   | C
  |   |
   ---
    D
  This example code is in the public domain.
 */
extern  byte segment;
extern byte digit;
extern byte val;

extern "C" { 
  void setup_ports();
}

extern "C" { 
  void display_segment();
}

// the setup routine runs once when you press reset:
void setup() {                
  // initialize the digital pins as outputs.

 Serial.begin(9600);
 
 setup_ports();
}

void loop() {
  segment=0;
  digit=0;
  display_segment();
  delay(1000);

  segment=1;
  digit=1;
  display_segment();
  delay(1000);

  segment=2;
  digit=2;
  display_segment();
  delay(1000);

  segment=3;
  digit=3;
  display_segment();
  delay(1000);

   segment=0;
  digit=4;
  display_segment();
  delay(1000);

  segment=1;
  digit=5;
  display_segment();
  delay(1000);

  segment=2;
  digit=6;
  display_segment();
  delay(1000);

  segment=3;
  digit=7;
  display_segment();
  delay(1000);

  segment=0;
  digit=8;
  display_segment();
  delay(1000);

  segment=1;
  digit=9;
  display_segment();
  delay(1000);
} // end loop
