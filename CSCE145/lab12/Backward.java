
public class Backward {

	char[] charIn;
	char[] charOut;
	public Backward() {
		this.charIn = new char[80];
		this.charOut = new char[80];
		for(int i = 0; i < 80; i++) {
			
			this.charOut[i] = ' ';  	
			}
	}
	public void reverse() {
		for(int i = 0; i < 80; i++){
			this.charOut[79-i] = this.charIn[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "This is a test.";
		Backward b1 = new Backward();
		for(int i = 0; i < input.length(); i++) {
			b1.charIn[i] = input.charAt(i);
			System.out.print(b1.charIn[i]);
			
		}
		System.out.println();
		b1.reverse();
		for(int i = 0; i < 80; i++) {
		
			System.out.print(b1.charOut[i]);
			
		}
	}

}
