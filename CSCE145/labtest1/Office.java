import java.util.Scanner;
public class Office {
	private int computers;
	private double energyConsumptionPerComputer;
	public  Office(int numOfComputers, double energyPerComputer) {
		if (getComputers() < 0) {
			Scanner keyboard = new Scanner(System.in);
			int energyConsumptionPerComputer = keyboard.nextInt();
			double totalEnergyConsumption = energyConsumptionPerComputer;
			System.out.println("The total energy used in all offices is " + totalEnergyConsumption + " units");
			double averageEnergyPerOffice = 0;
			System.out.println("The average energy used per office is " + averageEnergyPerOffice  + " units");
			System.exit(0);
		}
	
	}
	public void readInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Office Computer Energy Evaluator!");
		
	    
		System.out.println("How many computers are in the next office?");
		int computers = keyboard.nextInt();
		System.out.println("How much energy is used by each resident?");
		double energyConsumptionPerComputer = keyboard.nextDouble();
		energyConsumptionPerComputer = (energyConsumptionPerComputer * computers)+ 50;
		System.out.println("This office uses " + energyConsumptionPerComputer + " units of energy");
		double totalEnergyConsumption = energyConsumptionPerComputer;
		System.out.println("The total energy used in all offices is " + totalEnergyConsumption  + " units");
		double averageEnergyPerOffice = energyConsumptionPerComputer / computers;
		System.out.println("The average energy used per office is " + averageEnergyPerOffice + " units");
		System.exit(0);

	    


	}
			
		
	
	public int getComputers() {
		return computers;
	}
	public void setComputers(int computers) {
		this.computers = computers;
	
	}
	public double getEnergyConsumptionPerComputer() {
		return energyConsumptionPerComputer;
	}
	public void setEnergyConsumptionPerComputer(double energyConsumptionPerComputer) {
		this.energyConsumptionPerComputer = energyConsumptionPerComputer;
	}
	public double officeEnergy() {
		double energy = (computers * energyConsumptionPerComputer) +50;
		return energy;
		
	}
	public int nextInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	


	}


