import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

/**
 * @author Nate Fuller
 * How to send an email via Java code.
 * This uses one's GMail account.
 * Cannot CC or send to multiple recipients.
 */

public class OutlookEmail
{

	public static void main(String[] args)
	{
		final String from = "natefuller.jesussaves@gmail.com"; //your email address
		final String password = "N@than!&l"; //your password
		String to = from; //recipient's email address
		
		//body of email message
		String body = "<h:body style=background-color:white;font-family:verdana;color:#0066CC;"
				+ "If you are getting this you wrote your first email!<br/><br/>"
				+ "</body>";
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com"); // smtp server address
		props.put("mail.smtp.port", "443"); // smtp server port

		
		Session s = Session.getInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(from, password);
			}
		});
		
		try
		{
			System.out.println("Email...");
			Message m = new MimeMessage(s);
			m.setFrom(new InternetAddress(from)); //from email address
			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); //to recipient email address
			m.setSubject("Email sent via Java program");
			m.setContent(body, "text/html; charset=utf-8"); //sets content of the message you want to send
			m.setContent(body, "text/html; charset=utf-8");
			m.setContent("<h:body style=background-color:white;font-family:verdana;color:#0066CC;>"
				+ "If you are getting this, I wrote my first email via Java code!<br/><br/>"
				+ "</body>", "text/html; charset=utf-8");
			Transport.send(m);
			System.out.println("sent");
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e); //exception thrown if email address or password is wrong
		}
	}
}
