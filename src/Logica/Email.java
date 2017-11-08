package Logica;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
    
    String admin = "kore281295@gmail.com";
    String pass = "bryan2748245";
    public String namedisc, username, correo, msj;
    

    public boolean sendMail() {
        try {
            Properties pro = new Properties();
            pro.put("mail.smtp.host", "smtp.gmail.com");
            pro.setProperty("mail.smtp.starttls.enable", "true");
            pro.setProperty("mail.smtp.port", "587");
            pro.setProperty("mail.smtp.user", admin);
            pro.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(pro, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(msj);
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(admin));
            mensaje.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(correo));
            mensaje.setSubject("Compra Completada");
            mensaje.setContent(m);
            Transport t = session.getTransport("smtp");
            t.connect(admin, pass);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;
        } catch (MessagingException e) {
            System.out.println("Error---- "+e);
            return false;
        }
    }

}
