//the include statements
#include <avr/io.h>
#include <avr/interrupt.h>
#include "../../lib/functionsForRobot.h"

int main(void) 
{

	//setting up the timer and LEDs
	setup();
	
	int turnModFar = 2;
	int turnModClose = 2;
	
	int normalVelocity = 270;
	int forceFieldVelocity = 100;
	
	int dockBump = 0;
	
	//if the last signal was none of buoys this is true
	int noSignal = 1;
	
	//this is true only untill we find a buoy signal
	int neverFoundSignal = 1;
	
	//the last state we were in
	int lastState = 0;
	
	//for testing on to show docking fields off to run the program that docks
	if(off)
	{
		showDockingFields ();
	}
	
	//drive fowoards till we find the signal from the home
	findHomeSignal();
	
	while(1)
	{
		pickUpStop();
		
		//reseting the neverFoundSignal and lastState
		//so we dont have to reset the robot every time we need to test
		if(buttons() == buttonAdvance)
		{
			neverFoundSignal = 1;
			lastState = 0;
			beep();
			delayMs(1000);
			findHomeSignal();
		}
		
		switch (readIRPackets())
		{
		case dockRedBuoy :
			//turn on the right LED so we know what part of the field we are in
			commandLED(leftLED, off);
			commandLED(rightLED, on);
			
			//sets the play on and advance off and the power LED to green
			//so we know were are not in the force field
			robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
			
			//if this is the first time we have seen the red buoy signal
			if(neverFoundSignal)
			{
				//drives forwards till the IR signal changes
				forwardTillSignalChange(dockRedBuoy, normalVelocity);
				
				//setting to zero since we have found the signal
				neverFoundSignal = 0;
			}
			
			else
			{
				//turn left
				driveWheelsBumpStop(normalVelocity/*turnModFar*/, normalVelocity/turnModFar);
			}
			
			//setting noSignal to 0 since if we are in this case we have seen the signal
			noSignal = 0;
			
			//setting lastSignal to red buoy
			lastState = dockRedBuoy;
			
			break;
			
		case dockGreenBuoy :
			//turn on the left LED so we know what part of the field we are in
			commandLED(leftLED, on);
			commandLED(rightLED, off);
			
			//sets the play on and advance off and the power LED to green
			//so we know were are not in the force field
			robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
			
			//if this is the first time we have seen the green buoy signal
			if(neverFoundSignal)
			{
				//drives forwards till the IR signal changes
				forwardTillSignalChange(dockRedBuoy, normalVelocity);
				
				//setting to zero since we have found the signal
				neverFoundSignal = 0;
			}
			
			else
			{
				//turn right
				driveWheelsBumpStop(normalVelocity/turnModFar, normalVelocity/*turnModFar*/);
			}
			
			//setting noSignal to 0 since if we are in this case we have seen the signal
			noSignal = 0;
			
			//setting lastSignal to green buoy
			lastState = dockGreenBuoy;
			
			break;
			
		case dockRedGreenBuoy :
			//turn on both LED's so we know what part of the field we are in
			commandLED(bothLED, on);
			
			//sets the play on and advance off and the power LED to green
			//so we know were are not in the force field
			robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
			
			//drive forwards
			driveWheelsBumpStop(normalVelocity, normalVelocity);
			
			//setting noSignal to 0 since if we are in this case we have seen the signal
			noSignal = 0;
			
			//setting lastSignal to red green buoy
			lastState = dockRedGreenBuoy;
			
			break;
			
		case dockRedForceField :
		
			//turn on the right LED so we know what part of the field we are in
			commandLED(leftLED, off);
			commandLED(rightLED, on);
			
			//sets the play on and advance on and the power LED to green
			//so we know that we are in the force field
			robotLED(robotPlayAdvanceLED, robotPowerGreen, robotPowerOn);
			
			//turn left less
			driveWheelsBumpStop(forceFieldVelocity*turnModClose, forceFieldVelocity/turnModClose);
			
			//setting noSignal to 0 since if we are in this case we have seen the signal
			noSignal = 0;
			
			//setting lastSignal to red force field
			lastState = dockRedForceField;
			
			break;
			
		case dockGreenForceField :
			//turn on the left LED so we know what part of the field we are in
			commandLED(leftLED, on);
			commandLED(rightLED, off);
			
			//sets the play on and advance on and the power LED to green
			//so we know that we are in the force field
			robotLED(robotPlayAdvanceLED, robotPowerGreen, robotPowerOn);
			
			//turn right less
			driveWheelsBumpStop(forceFieldVelocity/turnModClose, forceFieldVelocity*turnModClose);
			
			//setting noSignal to 0 since if we are in this case we have seen the signal
			noSignal = 0;
			
			//setting lastSignal to green force field
			lastState = dockGreenForceField;
			
			break;
			
		case dockRedGreenForceField :
			//turn on both LED's so we know what part of the field we are in
			commandLED(bothLED, on);
			
			//sets the play on and advance on and the power LED to green
			//so we know that we are in the force field
			robotLED(robotPlayAdvanceLED, robotPowerGreen, robotPowerOn);
			
			//drive fowords
			driveWheelsBumpStop(forceFieldVelocity, forceFieldVelocity);
			
			//setting noSignal to 0 since if we are in this case we have seen the signal
			noSignal = 0;
			
			//setting lastSignal to red green force field
			lastState = dockRedGreenForceField;
			
			break;
			
		default :
			//turn on both LED's so we know what part of the field we are in
			commandLED(bothLED, off);
			
			//sets the play off and advance off and the power LED to green
			//so we know were are not in the force field
			robotLED(off, robotPowerGreen, robotPowerOn);
			
			//see if we have reached the goal
			if(isDocked() == 1)
			{
				stop();
				//play happy sound
				happySound();
			}
			
			while(isDocked() == 1)
			{
				
				//stop
				stop();

				//play happy sound
				//happySound();
				
			//sets the play off and advance off and the power LED to green
			//so we know were are not in the force field
				robotLED(off, robotPowerRed, robotPowerOn);	
			}
			
			//if the last state was red buoy then we know we are outside signal range and to the right 
			//of the dock
			if(lastState == dockRedBuoy)
			{
				//so we turn in place right
				dockBump = driveWheelsBumpStop(-normalVelocity, normalVelocity);
			}
			
			//if the last state was green buoy then we know we are outside signal range 
			//and to the left of the dock
			else if(lastState == dockGreenBuoy)
			{
				//so we turn in place left
				dockBump = driveWheelsBumpStop(normalVelocity, -normalVelocity);
			}
					
			else
			{
				//drive fowords
				dockBump = driveWheelsBumpStop(forceFieldVelocity, forceFieldVelocity);
			}
			
			if (dockBump == 1)
			{
				jiggleDock();	
			}
			
			//setting noSignal to 1 since if we are in this case we have not seen or lost the signal
			noSignal = 1;
			break;
		}
	}
}



