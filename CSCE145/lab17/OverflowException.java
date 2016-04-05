
public class OverflowException extends Exception {
	public OverflowException()
	{
		super("Too much gas.");
	}
	public OverflowException(String message1)
	{
		super(message1);
	}
}
