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

public class GMailEmail
{

	public static void main(String[] args)
	{
		final String from = "natefuller.jesussaves@gmail.com"; //your email address
		final String password = "N@than!&l"; //your password
		String to = "nfuller@themarinergroup.net"; //recipient's email address
		
		//body of email message
		String body = "<h:body style=background-color:white;font-family:verdana;color:#0066CC;>"
				+ "If you are getting this you wrote your first email!<br/><br/>"
				+ "</body>";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // smtp server address
		props.put("mail.smtp.port", "587"); // smtp server port

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
			//m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(from)); //to recipient email address
			m.setSubject("Email sent via Java program");
			m.setHeader("header", "header");
			m.setContent(body, "text/html; charset=utf-8"); //sets content of the message you want to send
			Transport.send(m);
			System.out.println("sent");
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e); //exception thrown if email address or password is wrong
		}
	}
}
