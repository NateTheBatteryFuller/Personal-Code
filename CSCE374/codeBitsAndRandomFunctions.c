
/*
start
turns on the right LED on the command module
*/

#include <avr/io.h>
void setupRightLED(void) {
// Set the fifth bit of the direction register for port D to 1.
// This sets pin 5 of port D, which controls the right LED, to output mode.
// Do this once, at the start of the program, before calling rightLEDon().
DDRD |= (1 << 5);
}
void rightLEDon(void) {
// Set the fifth bit of port D to 0.
// This activates the right LED.
PORTD &= ~(1 << 5);
}
int main(void) {
setupRightLED();
rightLEDon();
}

/*
end
turns on the right LED on the command module
*/

/*
start
a timer in milla seconds no more than three seconds
usage delayMs("time in milla seconds");
*/

#include <avr/io.h>
#include <avr/signal.h>
void setupTimer(void) {
// Set up the timer 1 interupt to be called every 1ms.
// It’s probably best to treat this as a black box.
// Basic idea: Except for the 71, these are special codes, for which details
// appear in the ATMega168 data sheet. The 71 is a computed value, based on
// the processor speed and the amount of "scaling" of the timer, that gives
// us the 1ms time interval.
TCCR1A = 0x00;
TCCR1B = 0x0C;
OCR1A = 71;
TIMSK1 = 0x02;
}
volatile uint16_t timerCount = 0;
volatile uint8_t timerRunning = 0;
void delayMs(uint16_t timeMs) {
// Delay for the given number of milliseconds.
// Call setupTimer() before this.
timerCount = timeMs;
timerRunning = 1;
while(timerRunning) {
// do nothing
}
}
SIGNAL(SIG_OUTPUT_COMPARE1A) {
// Interrupt handler called every 1ms.
// Decrement the counter variable, to allow delayMs to keep time.
if(timerRunning) {
if(timerCount != 0) {
timerCount--;
} else {
timerRunning = 0;
}
}
}

/*
end
a timer in milla seconds no more than three seconds
*/

/*
start
setting up communication with the robot using the serial connection
*/

void setupSerialPort(void) {
// Set the transmission speed to 57600 baud, which is what the Create expects,
// unless we tell it otherwise.
UBRR0 = 19;
// Enable both transmit and receive.
UCSR0B = 0x18;
// Set 8-bit data.
UCSR0C = 0x06;
}
void byteTx(uint8_t value) {
// Transmit one byte to the robot.
// Wait for the buffer to be empty.
while(!(UCSR0A & 0x20)) {
// Do nothing.
}
// Send the byte.
UDR0 = value;
}

/*
end
setting up communication with the robot using the serial connection
*/

/*
start
example main funciton the blinks teh leDs on both the Create and the Command Module
*/

int main(void) {
// Disable interrupts. ("Clear interrupt bit")
cli();
// One-time setup operations.
setupSerialPort();
setupRightLED();
setupLeftLED();
setupTimer();
// Enable interrupts. ("Set interrupt bit")
sei();
byteTx(128); // Start the open interface.
byteTx(132); // Switch to full mode.
// Toggle the LEDs once each second.
while(2+2==4) {
rightLEDon();
leftLEDoff();
byteTx(139); // Opcode for "Set LEDs"
byteTx(10); // Led bits: both on
byteTx(0); // Power led color: Fully green
byteTx(255); // Power led intensity
delayMs(1000);
rightLEDoff();
leftLEDon();
byteTx(139); // Opcode for "Set LEDs"
byteTx(0); // Led bits: both off
byteTx(255); // Power led color: Fully red
byteTx(255); // Power led intensity
delayMs(1000);
}
}

/*
end
example main funciton the blinks the LEDs on both the Create and the Command Module
*/

/*
start
sending data to the Command Module
*/

uint8_t byteRx(void) {
// Receive one byte from the robot.
// Call setupSerialPort() first.
// Wait for a byte to arrive in the recieve buffer.
while(!(UCSR0A & 0x80)) ;
// Return that byte.
return UDR0;
}

/*
end
example main funciton the blinks the LEDs on both the Create and the Command Module
*/

/*
start
example of reading bump sensors and toggling the lights
*/

int main() {
// Disable interrupts. ("Clear interrupt bit")
cli();
// One-time setup operations.
setupSerialPort();
setupRightLED();
setupLeftLED();
setupTimer();
// Enable interrupts. ("Set interrupt bit")
sei();
byteTx(128); // Start the open interface.
byteTx(132); // Switch to full Mode
while(2+2==4) {
delayMs(100);
// Ask the robot about its bump sensors.
byteTx(142); // Opcode for "Read sensors"
byteTx(7); // Sensor packet 7: Bumps and wheel drops
// Read the one-byte response and extract the relevant bits.
uint8_t bumps = byteRx();
uint8_t bumpRight = bumps & (1 << 0);
uint8_t bumpLeft = bumps & (1 << 1);
// Set the command module LEDs based on this sensor data.
if(bumpLeft) {
leftLEDon();
}
else {
leftLEDoff();
}
if(bumpRight) {
rightLEDon();
}
else {
rightLEDoff();
}
}
}

/*
end
example of reading bump sensors and toggling the lights
*/

/*
start
example of switching between sending and receaving between the robot and controler
*/

#define SERIAL_CREATE (1)
#define SERIAL_USB (2)
void setSerialDestination(uint8_t dest) {
// Which serial port should byteTx and byteRx talk to?
// Ensure any pending bytes have been sent. Without this, the last byte sent
// before calling this might seem to disappear.
delayMs(10);
// Configure the port.
if(dest == SERIAL_CREATE) {
PORTB &= ˜0x10;
} else {
PORTB |= 0x10;
}
// Wait a bit to let things get back to normal. According to the docs, this
// should be at least 10 times the amount of time needed to send one byte.
// This is less than 1 millisecond. We are using a much longer delay to be
// super extra sure.
delayMs(10);
}

/*
end
example of switching between sending and receaving between the robot and controler
*/

/*
start
example of sending information to the computer
*/

while(1) {
setSerialDestination(SERIAL_CREATE);
uint8_t bumpLeft, bumpRight;
readBumps(&bumpLeft, &bumpRight);
setSerialDestination(SERIAL_USB);
if(bumpLeft) byteTx(’L’);
if(bumpRight) byteTx(’R’);
byteTx(’\n’);
}

/*
end
example of sending information to the computer
*/

