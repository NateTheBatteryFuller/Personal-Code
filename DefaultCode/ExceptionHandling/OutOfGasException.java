
public class OutOfGasException extends Exception{
	public OutOfGasException()
	{
		super("Out of gas.");
	}
	public OutOfGasException(String message)
	{
		super(message);
	}
}
