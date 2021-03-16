// EECS1021 Lab G Part 2
// Import libraries
#include <Arduino.h>
#include <U8x8lib.h>

// Make synonyms using define
#define MOSFET 2 // The MOSFET driver for the water pump on digital I/O 2
#define REDLED 4 // Big red LED on digital I/O 4
#define BUTTON 6 // Push button on digital I/O 6
#define MOISTURE A1

// Create an instance of the 'U8X8_SSD1306_128X64_NONAME_HW_I2C' class
auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(/* reset=*/ U8X8_PIN_NONE);

/*-----------------------Intiaize the Grove board----------------*/
void setup() {
  pinMode(MOSFET, OUTPUT); // Sets the D2 pin (MOSFET + Pump) to output
  pinMode(REDLED, OUTPUT); // Sets the D4 pin (LED) to output
  pinMode(BUTTON, INPUT); // Sets the D6 pin (Button) to input
  digitalWrite(MOSFET, LOW); //pump off

  display.begin(); // start up the OLED display
  display.setFlipMode(0); //set to 1 or 0, depending on orientation of board
  display.clearDisplay();
  display.setFont(u8x8_font_profont29_2x3_r); // set font

}
void loop() {

  //place the cursor
  display.setCursor(0,0);

  if(digitalRead(BUTTON) == HIGH)
  {
    digitalWrite(MOSFET, HIGH); // pump on
    display.clearDisplay();

    display.print("water! ");
  }
  else{
    digitalWrite(MOSFET, LOW); // pump off

    display.print("no water");
  }

}
