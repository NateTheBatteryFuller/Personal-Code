import java.util.Scanner;
public class Weather {
	int[] temperature;
	public Weather() {
		this.temperature = new int[5];
	}
	public static double calcAverage(int[] temperature) {
		//Scanner keyboard = new Scanner(System.in);
		double sum = 0;
		for (int index = 0; index < 5; index++) {
			//temperature[index] = (int) keyboard.nextDouble();
			sum = sum + temperature[index];
		}
		return (sum/5.0);
		
	}
	public static void printArray(int[] temperature) {
		
		for (int index = 0; index < 5; index++) {
			System.out.println(temperature[index]);
			
		}
		
		
	}
	/**
	 * @param args
	 * @return 
	 * @return 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Weather w1 = new Weather ();
		int input = 0;
		double output = 0;
		int output2 = 0;
		System.out.println("Welome to the Average Temperature Program");
		System.out.println("Enter five temperatures: ");
		double[] temperature = new double[5];
		double sum = 0;
		for (int index = 0; index < 5; index++) {
			
			w1.temperature[index] = keyboard.nextInt();
			//Object.varialbe(attribute,array)[accessing the array] = obejct.method();
//			w1.temperature[index] = output;
//			temperature[index] = 
//			sum = sum + temperature[index];
		}
		output = calcAverage(w1.temperature);
		printArray(w1.temperature);
//		output = Weather.calcAverage(w1.temperature);
//		Weather.printArray(w1.temperature);


		System.out.println("The average of the temperatures are " + output);
//		System.out.println("Temperatures in the array are: " + temperature[0] +  " " + temperature[1] + " "  + temperature[2] +  " " + temperature[3] + " " + temperature[4]);
//		System.out.println(output2);
		System.out.println("Thank you for using the Average Temperature Program.");
		}
	//charOut[index]= charIn[79-index];
		

		

}

