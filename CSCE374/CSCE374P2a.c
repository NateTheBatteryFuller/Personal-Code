//the include statements
#include <avr/io.h>
#include <avr/interrupt.h>
#include <stdio.h>
#include "../../lib/functionsForRobot.h"

int main(void) 
{

	//setting up the timer and LEDs
	setup();
	
	//gives the robot time to accept the commands to make squares
	delayMs(1000);
	
	//sets the play and advance LEDs off and the power LED to red
	robotLED(off, robotPowerRed, robotPowerOn);

	//the messages we will print to the console
	char batteryMessage[] = "the value of the battery sensor is: ";	
	char wallMessage[] = "the value of the wall sensor is: ";
	char cliffLeftMessage[] = "the value of the cliff Left sensor is: ";
	char cliffRightMessage[] = "the value of the cliff Right sensor is: ";
	char cliffFrontLeftMessage[] = "the value of the cliff Front Left sensor is: ";
	char cliffFrontRightMessage[] = "the value of the cliff Front Right sensor is: ";

	while (1)
	{
		//delay so we dont print to fast
		delayMs(500);

		//change to the robot to get vaues of sensors
		setSerialDestination(serialCreate);

		//the vars for storing the sensor data
		uint16_t battery = sensorValues(packetBatteryCharge);
		uint16_t wall = sensorValues(packetWallSignal);
		uint16_t cliffLeft = sensorValues(packetCliffLeftSignal);
		uint16_t cliffRight = sensorValues(packetCliffRightSignal);
		uint16_t cliffFrontLeft = sensorValues(packetCliffFrountLeftSignal);
		uint16_t cliffFrontRight = sensorValues(packetCliffFrountRightSignal);
		
		//change to the USB to print values of sensors
		setSerialDestination(serialUSB);
		
		//prints the state of the battery sensor
		printString(batteryMessage);
		printUint16_t(battery);		
		byteTx('\n');

		//prints the state of the wall sensor
		printString(wallMessage);
		printUint16_t(wall);		
		byteTx('\n');

		//prints the state of the cliff sensors
		printString(cliffLeftMessage);
		printUint16_t(cliffLeft);		
		byteTx('\n');

		printString(cliffRightMessage);
		printUint16_t(cliffRight);		
		byteTx('\n');

		printString(cliffFrontLeftMessage);
		printUint16_t(cliffFrontLeft);		
		byteTx('\n');
		
		printString(cliffFrontRightMessage);
		printUint16_t(cliffFrontRight);		
		byteTx('\n');

		//puts three new lines between the old and new sensor data
		byteTx('\n');
		byteTx('\n');
		byteTx('\n');
	}
}
