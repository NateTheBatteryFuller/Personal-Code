//the include statements
#include <avr/io.h>
#include <avr/interrupt.h>
#include "../../lib/functionsForRobot.h"

int main(void) 
{

	//setting up the timer and leds
	setup();
	
	//gives the robot time to accept the commands to make squares
	delayMs(1000);
	
	//sets the play and advance LEDs off and the power LED to red
	robotLED(off, robotPowerRed, robotPowerOn);
	
	while (1)
	{
		delayMs(100);
		
		// Ask the robot about its bump sensors.
		byteTx(opReadSensors); // Opcode for "Read sensors"
		byteTx(packetButtons); // Sensor packet 7: Bumps and wheel drops
		
		// Read the one-byte response and extract the relevant bits.
		uint8_t buttons = byteRx();
		uint8_t playButton = buttons & (1 << 0);
		uint8_t advanceButton = buttons & (1 << 2);
		
		//makes a square counterclockwise of legnth 250 mm at velocity 300 mm/s
		if(advanceButton) 
		{	
			//turn on the advance LED on the robot and sets the power LED to 
			delayMs(500);
			
			//turns on the advance LED and sets the power LED to green
			robotLED(robotAdvanceLED, robotPowerGreen, robotPowerOn);
			
			//makes a square countercolokwise with sides = 250mm at 300 mm/s
			makeSquareCCW(300, 250);
		}
		
		//makes a square clockwise of legnth 250 mm at velocity 300 mm/s
		if(playButton)
		{
			//turn on the play LED on the robot and sets the power LED to green
			delayMs(500);
			
			//turn on the play LED and sets the power LED to green
			robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
			
			//makes a square colokwise with sides = 250mm at 300 mm/s
			makeSquareCW(300, 250);
		}
		
		//turns off the play LED and sets the pwer LED to red
		robotLED(off, robotPowerRed, robotPowerOn);
	}
}
