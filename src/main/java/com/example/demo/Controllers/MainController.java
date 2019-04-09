package com.example.demo.Controllers;

import com.example.demo.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@Controller
public class MainController {

    @Controller
    public class EmailController {


        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String sendEmail(Model model) throws IOException, MessagingException {
           // sendmail();
            return "Pages/Accueil/index";
        }
    }


    private void sendmail() throws AddressException, MessagingException, IOException {

        Properties props = new Properties();

        if (!Utils.netIsAvailable())
        {
            props.put("mail.smtp.host", "localhost");
            props.put("mail.smtp.port", "1025");
        }else
        {
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        }




        // Nous envoyeur
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("amedechouk@gmail.com", "amede1234");
            }
        });
        //


        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("amedechouk@gmail.com", false)); // From
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("aulerien80@gmail.com")); // To
        msg.setSubject("Mon Petit Test");
        msg.setContent("J'ai envoyé le mail depuis Spring Boot", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Amede Angel Aulerien Email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();
        //attachPart.attachFile("static/img/apartement.jpg");
        //multipart.addBodyPart(attachPart);

       // msg.setContent(multipart);
        Transport.send(msg);
    }
}
