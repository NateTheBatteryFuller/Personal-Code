/*
objective
Write a program that responds in the following ways:
1. Periodically toggle both of the Command Module’s LEDs.
2. If the left bumper is pressed, light the robot’s left LED.
3. If the right bumper is pressed, light the robot’s right LED.
*/

//the include statements
#include <avr/io.h>
#include <avr/interrupt.h>
#include "../../lib/functionsForRobot.h"

int main(void) {

	//setting up the timer and leds
	setup();
	
	//the starting state of the LEDs on the command module is off
	int stateOfCommandLEDs = off; 
	
	//the loop that checks if the bumpers have been pressed
	while(1) {
		
		//this if statment toggles the state of the command modules LEDs
		if(stateOfCommandLEDs == on){
			commandLED(bothLED, off);
			stateOfCommandLEDs = off; 
		}
		
		else{
			commandLED(bothLED, on);
			stateOfCommandLEDs = on; 
		}
		
		//this for loop lets us keep the delay low while not blinking the command module LEDs to fast
		for(int i = 0; i < 10; i++){
			
			delayMs(100);
			
			
			// Ask the robot about its bump sensors.
			uint8_t bumpRight = 0;
			uint8_t bumpLeft = 0;
			bumpSensors(&bumpLeft, &bumpRight);

			// Set the command module LEDs based on this sensor data.
			if(bumpLeft && bumpRight){
				robotLED(robotPlayAdvanceLED, robotPowerGreen, robotPowerOn);
			}
			
			else if(bumpLeft){
				robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
			}
			
			else if(bumpRight) {
				robotLED(robotAdvanceLED, robotPowerGreen, robotPowerOn);
			}
			
			else {
				robotLED(off, robotPowerGreen, robotPowerOn);
			}
		}
	}
}
