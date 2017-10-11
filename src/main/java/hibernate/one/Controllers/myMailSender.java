package hibernate.one.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

/**
 * @author Bianca Culea
 */

@Component
public class myMailSender {

    @Autowired
    private JavaMailSender JMSender;

    @Async
    public void send(String to, String subject, String body) throws javax.mail.MessagingException {
        LocalDateTime dt =LocalDateTime.now();
        MimeMessage message = JMSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setText(dt+" - "+body, true);
        helper.setSubject(subject);
        JMSender.send(message);
    }


    @Async
    public void sendWithAttachments(String to, String subject, String body ) throws javax.mail.MessagingException {
        try{
            LocalDateTime dt =LocalDateTime.now();
            Path path = Paths.get("d:/fisiereJ8/me.gif");
            String category="cat.jpg";
            byte[] content = Files.readAllBytes(path);
            MimeMessage message = JMSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setText( dt+" - "+ body , true);
            helper.setSubject(subject);
            helper.addAttachment(category, new ByteArrayResource(content));
            JMSender.send(message);
        }catch(IOException e){e.printStackTrace();}
    }

    @Async
    public void sendExceptionMail(String to, Exception e , File file) throws javax.mail.MessagingException {
        try{
            LocalDateTime dt =LocalDateTime.now();
            String category="exception.txt";
            MimeMessage message = JMSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setText( e.toString() , true);
            helper.setSubject("Exception - on: "+dt);
            helper.addAttachment(category, file);
            JMSender.send(message);
        }catch(Exception e1){e1.printStackTrace();}
    }
}
