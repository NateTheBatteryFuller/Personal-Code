
public class FootballPlayer {
	private String name;
	private int gamesPlayed;
	private int numberOfInjuries;
	
	public FootballPlayer(String nombre, int juegos, int numero){
		this.name=nombre;
		this.gamesPlayed=juegos;
		this.numberOfInjuries=numero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getNumberOfInjuries() {
		return numberOfInjuries;
	}

	public void setNumberOfInjuries(int numberOfInjuries) {
		this.numberOfInjuries = numberOfInjuries;
	}
	public void display() {
		System.out.println("The Football Player's name is: " + getName());
		System.out.println("The number of games that " + getName() + " has played in is: " + getGamesPlayed());
		System.out.println("The total number of injuries that " + getName() + " has is: " + getNumberOfInjuries());
	}
}
