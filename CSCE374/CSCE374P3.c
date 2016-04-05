//the include statements
#include <avr/io.h>
#include <avr/interrupt.h>
#include "../../lib/functionsForRobot.h"

int main(void) 
{

	//setting up the timer and LEDs
	setup();
	
	//gives the robot time to accept the commands
	delayMs(1000);
	
	//sets the play on and advance LEDs off and the power LED to green
	robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
	
	//the tuning parameters used for the PID controller
	//tuned for shane
	int kp = 1;
	int ki = 0.7;
	int kd = 0.5;
	
	//used for finding out if we have lost the wall
	
	//this is the number that we use to see if we have lost the wall. The bigger it
	//is the longer the robot goes in circles before trying to find the wall
	int driveLineOn = 400; 
	
	//the counter
	int driveLine = 0; 
	
	//the delta t assumed to be 1 for simplicity 
	int deltaT = 1;
	
	//the value we are trying to get
	//for shane also depends on how charged the battery is
	int setPoint = 25; 
	
	//the vars used in the calculations
	int errorCurrent = 0;
	int errorPrevious = 0;
	int errorIntegral  = 0;
	int errorDerivative = 0;
	int state = 0;
	
	//the final answer we care about
	int controllerOutput = 0;
	
	//in the event we are not near a wall to start with we drive forwards till we hit a wall
	//or close so the sensor picks it up
	findWall(setPoint);
	
	//sets the play on and advance LEDs off and the power LED to green
	robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
	
	while (1)
	{
		//begin lostWall
		
		//in the event that the wall sensor is less than the setPoint
		//we increment the driveLine because the wall might be missing
		if(sensorValues(packetWallSignal) < setPoint)
		{
			//incrementing the counter
			driveLine ++;
			
			//setting the command LED's to tell that the value of the sensor is less than the setPoint
			commandLED(rightLED, on);
			commandLED(leftLED, off);
		}
		
		//if the wall sensor is >= than the setPoint we know we are tracking the wall
		//so we reset driveLine
		else
		{
			//resetting the counter to 0 since we found a wall
			driveLine = 0;
			
			//setting the command LED's to tell that the value of the sensor is greater than the setPoint
			commandLED(rightLED, off);
			commandLED(leftLED, on);
		}
		
		//if driveLine is greater than a predetermined value driveLineOn we assume 
		//that we have lost the wall and we try to find it
		if(driveLine > driveLineOn)
		{
			//while we have not found the wall we drive forwards
			findWall(setPoint);
			
			//resetting the driveLine since we found the wall
			driveLine = 0;
		}
		//end lostWall
		
		//getting the current state
		state = sensorValues(packetWallSignal);
		
		//setting the previous error the the old current error
		errorPrevious = errorCurrent;
		
		//getting the current error
		errorCurrent = state - setPoint;
		
		//getting the Integral term
		errorIntegral = (errorIntegral + (errorCurrent*deltaT));
		
		//getting the derivative term
		errorDerivative = (errorCurrent - errorPrevious)/deltaT;
		
		//getting the controller output
		controllerOutput = (kp*errorCurrent + ki*errorIntegral + kd*errorDerivative);
		
		//in the following section we use the output of the controller

		//using the output of the controller to modify the drive command 
		//multiplying the controller by 2 made the wall following much smoother and the right turn much tighter
		driveWheelsBump( defaultVelocity + (controllerOutput*2), defaultVelocity - (controllerOutput*2));
		
		//for convenience when we pick the robot up it stops driving and the program does nothing
		pickUpStop();
		
		//resetting the LED's since pickUpStop set power to red and the rest off
		robotLED(robotPlayLED, robotPowerGreen, robotPowerOn);
	}
}
