// Program name : Lab6.ino
// Purpose      : Program which reads humidity and temperature and displays the values obtained by using assembly code
// Name         : Bryant Hernandez
// Date         : 03/31/2020
// Input        : N/A
// Output       : N/A
// Assumptions  : N/A

// DHT Temperature & Humidity Sensor
// Unified Sensor Library Example
// Written by Tony DiCola for Adafruit Industries
// Released under an MIT license.

// Depends on the following Arduino libraries:
// - Adafruit Unified Sensor Library: https://github.com/adafruit/Adafruit_Sensor
// - DHT Sensor Library: https://github.com/adafruit/DHT-sensor-library

#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include <Arduino.h>
#include <TM1637Display.h>

// Module connection pins (Digital Pins) for TM 1637
#define CLK 9
#define DIO 8

TM1637Display display(CLK, DIO); // create a display object
                      // LAB6 REMOVE the ABOVE LINE


#define DHTPIN            2         // Pin which is connected to the DHT sensor.

// Uncomment the type of sensor in use:
#define DHTTYPE           DHT11     // DHT 11 
//#define DHTTYPE           DHT22     // DHT 22 (AM2302)
//#define DHTTYPE           DHT21     // DHT 21 (AM2301)

// See guide for details on sensor wiring and usage:
//   https://learn.adafruit.com/dht/overview

DHT_Unified dht(DHTPIN, DHTTYPE);

// The amount of time (in milliseconds) between tests
#define TEST_DELAY   2000

const uint8_t  d = SEG_B | SEG_C | SEG_D | SEG_E | SEG_G;
const uint8_t  O = SEG_A | SEG_B | SEG_C | SEG_D | SEG_E | SEG_F;
const uint8_t  n = SEG_C | SEG_E | SEG_G;
const uint8_t  E = SEG_A | SEG_D | SEG_E | SEG_F | SEG_G;

 const uint8_t H = SEG_B | SEG_C | SEG_E | SEG_F | SEG_G; // H
 const uint8_t T =  SEG_D | SEG_E | SEG_F | SEG_G; // t
 const uint8_t BLANK = 0;


uint32_t delayMS;

extern byte data[];
extern byte input;
extern byte result;

extern "C" {
     void display_symbol();
     void sendBrightness();
     void stopBit();
     void startBit();
     void encodeDigit();
}

void setup() {
  Serial.begin(9600); 
  // Initialize device.
  dht.begin();
  Serial.println("DHTxx Unified Sensor Example");
  // Print temperature sensor details.
  sensor_t sensor;
  dht.temperature().getSensor(&sensor);
  Serial.println("------------------------------------");
  Serial.println("Temperature");
  Serial.print  ("Sensor:       "); Serial.println(sensor.name);
  Serial.print  ("Driver Ver:   "); Serial.println(sensor.version);
  Serial.print  ("Unique ID:    "); Serial.println(sensor.sensor_id);
  Serial.print  ("Max Value:    "); Serial.print(sensor.max_value); Serial.println(" *C");
  Serial.print  ("Min Value:    "); Serial.print(sensor.min_value); Serial.println(" *C");
  Serial.print  ("Resolution:   "); Serial.print(sensor.resolution); Serial.println(" *C");  
  Serial.println("------------------------------------");
  // Print humidity sensor details.
  dht.humidity().getSensor(&sensor);
  Serial.println("------------------------------------");
  Serial.println("Humidity");
  Serial.print  ("Sensor:       "); Serial.println(sensor.name);
  Serial.print  ("Driver Ver:   "); Serial.println(sensor.version);
  Serial.print  ("Unique ID:    "); Serial.println(sensor.sensor_id);
  Serial.print  ("Max Value:    "); Serial.print(sensor.max_value); Serial.println("%");
  Serial.print  ("Min Value:    "); Serial.print(sensor.min_value); Serial.println("%");
  Serial.print  ("Resolution:   "); Serial.print(sensor.resolution); Serial.println("%");  
  Serial.println("------------------------------------");
  // Set delay between sensor readings based on sensor details.
  delayMS = sensor.min_delay / 1000;
}

void loop() {
  int t1,t2;
  int h1, h2;
  // Delay between measurements.
  delay(delayMS);
  // Get temperature event and print its value.
  sensors_event_t event;  
  dht.temperature().getEvent(&event);
  if (isnan(event.temperature)) {
    Serial.println("Error reading temperature!");
  }
  else {
    Serial.print("Temperature: ");
    Serial.print(event.temperature);
    Serial.println(" *F");
    t1=event.temperature/10;
    t2=event.temperature;
    t2=t2%10;
    Serial.println(t1);
    Serial.println(t2);
  }
  // Get humidity event and print its value.
  dht.humidity().getEvent(&event);
  if (isnan(event.relative_humidity)) {
    Serial.println("Error reading humidity!");
 
  }
  else {
    Serial.print("Humidity: ");
    Serial.print(event.relative_humidity);
    Serial.println("%");
    h1=event.relative_humidity/10;
    h2=event.relative_humidity;
    h2=h2%10;
    Serial.println(h1);
    Serial.println(h2);
  }

  // Selectively set different digits
  data[0] = H;
  data[1] = BLANK;
  input = h1; // the h1 humidity digit
  encodeDigit();
  data[2] = result;
  input = h2; // the h2 humidity digit
  encodeDigit();
  data[3] = result;
  display_symbol();
  delay(TEST_DELAY);

  data[0] = T;
  data[1] = BLANK;
  input = t1; // the t1 humidity digit
  encodeDigit();
  data[2] = result;
  input = t2; // the t2 humidity digit
  encodeDigit();
  data[3] = result;
  display_symbol();
  delay(TEST_DELAY);

  
  data[0] = d;
  data[1] = O;
  data[2] = n;
  data[3] = E;
  display_symbol();
  delay(TEST_DELAY);

  data[0] = T;
  data[1] = BLANK;
  data[2] = H;
  data[3] = E;
  display_symbol();
  delay(TEST_DELAY);
}
