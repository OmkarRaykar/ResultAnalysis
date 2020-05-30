import java.io.IOException;
import java.util.Date;
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
public class Email_PDF {
 
	
    
    
    		public void sendEmail(String fileName, String emailId)throws Exception {
        Properties props = null;
        if (props == null) {
            props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.user", "jobjunction.asp@gmail.com");
            props.put("mail.smtp.pwd", "jobjunction");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        }
        
      
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("jobjunction.asp@gmail.com"));
        msg.setSubject("Auto Generated Mail");
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
        Transport transport = session.getTransport("smtp");
        BodyPart message1 = new MimeBodyPart();
        message1.setText("Testing Mail");
        
        MimeBodyPart message2 = new MimeBodyPart();
        
        DataSource source = new FileDataSource(fileName);
        message2.setDataHandler(new DataHandler(source));
        message2.setFileName(fileName);
        
        Multipart multipart = new MimeMultipart();
        
        multipart.addBodyPart(message1);
        multipart.addBodyPart(message2);
        
        msg.setContent(multipart);
        
        transport.connect("smtp.gmail.com", 587, "jobjunction.asp@gmail.com", "jobjunction");
        transport.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Mail sent successfully at "+emailId);
        transport.close();
        
    }
}

 