//the include statements
#include <avr/io.h>
#include <avr/interrupt.h>
#include <stdio.h>
#include "../../lib/functionsForRobot.h"

int main(void) 
{

	//setting up the timer and LEDs
	setup();

	//sets the play and advance LEDs off and the power LED to red so we know our program is running
	robotLED(off, robotPowerRed, robotPowerOn);

	
	while (1)
	{	
		//while the remote is sending out a valid signal we do what it says
		while(readIRPackets() != IRnoSignal)
		{
			//translating remote signals to action
			roombaRemote();
		}
		
		//if remote is not telling us to move we make sure we are not moving
		driveWheels(off,off);
	}
}
