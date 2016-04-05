
public class OffensivePlayer extends FootballPlayer{
	private int totalYards;
	private int numberOfTDs;
	public OffensivePlayer(String nombre, int juegos, int numero, int yardage, int touchdowns) {
		super(nombre, juegos, numero);
		this.totalYards=yardage;
		this.numberOfTDs=touchdowns;
		}
	public int getTotalYards() {
		return totalYards;
	}
	public void setTotalYards(int totalYards) {
		this.totalYards = totalYards;
	}
	public int getNumberOfTDs() {
		return numberOfTDs;
	}
	public void setNumberOfTDs(int numberOfTDs) {
		this.numberOfTDs = numberOfTDs;
	}
	public void display(){
		super.display();
		System.out.println("The Offensive Player's total yards is: " + getTotalYards());
		System.out.println("The total number of touchdowns he has is: " + getNumberOfTDs());
	}
	
}
