
public class QuarterBack extends OffensivePlayer {
	private int interceptionsThrown;
	private double completionPercentage;

	public QuarterBack(String nombre, int juegos, int numero, int yardage,
			int touchdowns, int garcia, double percentage) {
		super(nombre, juegos, numero, yardage, touchdowns);
		this.interceptionsThrown=garcia;
		this.completionPercentage=percentage;
		
	}

	public int getInterceptionsThrown() {
		return interceptionsThrown;
	}

	public void setInterceptionsThrown(int interceptionsThrown) {
		this.interceptionsThrown = interceptionsThrown;
	}

	public double getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(double completionPercentage) {
		this.completionPercentage = completionPercentage;
	}
	public void display(){
		super.display();
		System.out.println("The Quarterback threw: " + getInterceptionsThrown() + " interceptions.");
		System.out.println("The Quarterback's completion percentage is: " + getCompletionPercentage());
		
	}
}
