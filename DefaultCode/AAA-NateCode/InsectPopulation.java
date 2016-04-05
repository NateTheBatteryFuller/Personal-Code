//import  java.util.Scanner;
//csce 145 lab 11
public class InsectPopulation {
	private int population;
	public InsectPopulation (int s) {
		this.population=s;
	}
	public void breed() {
		this.population=this.population*2;
	}
	public void spray() {
		this.population=this.population*9/10;
	}
	public int getpopulation() {
		return population;
	}
	public int display(){
		System.out.println("The population is now currently "+ getpopulation() + " insects");
		return population;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsectPopulation pop1 = new InsectPopulation(10);
		for (int p=1; p<=8; ++p) {
			System.out.println(pop1.getpopulation());
			pop1.breed();
			System.out.println(pop1.getpopulation());
			pop1.spray();
			System.out.println(pop1.getpopulation());
			pop1.display();
		}
	}
}
