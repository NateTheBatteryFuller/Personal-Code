
public class SavingsAccount1 {
	String name;
	String owner;
	double balance;
	public SavingsAccount1(String name, String owner, double balance) 
		{
		//super();
		this.name = name;
		this.owner = owner;
		this.balance = balance;
		}
	public SavingsAccount1() 
		{
		//super();
		this.name = "name";
		this.owner = "owner";
		this.balance = 0;
		}
	public void deposit(double b)
		{
			balance = balance + b; 
		}
	public void withdraw(double b)
		{
			balance = balance - b;
		}
	public void close() 
		{
			balance = 0;
			owner = "Nate Fuller";
		}
	public String getAccountName()
		{
			return name;
		}
	public String getOwner()
		{
			return owner;
		}
	public double getBalance()
		{
			return balance;
		}
	public void setName(String s)
		{
			name = s;
		}
	public void setOwner(String s)
		{
			owner = s;
		}
	public String toString()
		{
			return "Name of Account: " + name + "\nOwner of Account: " + owner + "\nBalance: " + balance;
		}
		
	public static void main(String[] args) 
	{
		SavingsAccount1 method = new SavingsAccount1("Savings","NateFuller",0);
		System.out.println(method.getAccountName());
		System.out.println(method.getOwner());
		System.out.println("Your balance is: " + method.getBalance() + " dollars");
		method.deposit(100);
		System.out.println("You deposited: " + method.getBalance() + " dollars");
		method.withdraw(45);
		System.out.println("Your new balance is: " + method.getBalance() + " dollars");
		method.close();
		System.out.println(method.toString()); 
		
		
		
	}
}
