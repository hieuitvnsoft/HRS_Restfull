/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndDAO;

/**
 *
 * @author Admin
 */

    import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
 private static final String host = "smtp.gmail.com";
    private static final String port = "587";
    private static final String userName = "thanhhoa280297@gmail.com";
    private static final String password = "Votinhlaanh94";
   public static void Send(String mailto, String subject, String context) {    
      
      String from = "web@gmail.com";

      // Assuming you are sending email from localhost
      

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailto));

         // Set Subject: header field
         message.setSubject(subject);

         // Now set the actual message
         message.setText(context);

         // Send message
         Transport.send(message);
         
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}

