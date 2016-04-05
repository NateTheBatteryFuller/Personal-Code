import java.io.IOException;


public class SystemFun
{

	public SystemFun()
	{
		int status = 1;
		System.class.getName().substring(0);
		System.err.println("ERF");
		try
		{
			System.in.read();
			System.in.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		//System.exit(status);
		System.gc();
		System.getenv();
		System.getProperties();
		System.getSecurityManager();
	}
	
	public static void main(String[] args)
	{
		SystemFun erf = new SystemFun();
	}
}
