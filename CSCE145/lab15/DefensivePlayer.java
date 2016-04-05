
public class DefensivePlayer extends FootballPlayer{
	private int numberOfInterceptions;
	private int numberOfTackles;
	public DefensivePlayer(String nombre, int juegos, int numero, int interceptions, int tackles) {
		super(nombre, juegos, numero);
		this.numberOfInterceptions=interceptions;
		this.numberOfTackles=tackles;
		
	}
	public int getNumberOfInterceptions() {
		return numberOfInterceptions;
	}
	public void setNumberOfInterceptions(int numberOfInterceptions) {
		this.numberOfInterceptions = numberOfInterceptions;
	}
	public int getNumberOfTackles() {
		return numberOfTackles;
	}
	public void setNumberOfTackles(int numberOfTackles) {
		this.numberOfTackles = numberOfTackles;
	}
	public void display(){
		super.display();
		System.out.println("The number of interceptions that the defensive player has is: " + getNumberOfInterceptions());
		System.out.println("The number of tackles that the defensive player has is: " + getNumberOfTackles());
	}
}
