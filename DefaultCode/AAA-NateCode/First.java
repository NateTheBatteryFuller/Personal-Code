
public class First
{
	private String	erpa;
	private String	derp;

	public First()
	{
		String secret = "";
		String secret1 = "";
		String secret2 = "";
	}
	
	private First(String erpa, String derp)
	{
		//this.setErpa(erpa);
		//this.derp = derp;
	}
	
	public void secret1(String s, String t)
	{
		System.out.println("Do you want to know a secret?");
		System.out.println("The answer can be found at " + s + t);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int i = 99/100;
		System.out.println(i);
	}

	public String getErpa()
	{
		return erpa;
	}

	public void setErpa(String erpa)
	{
		this.erpa = erpa;
	}

}
