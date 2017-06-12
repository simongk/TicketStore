package com.simongk.mail;

import com.simongk.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Szymon Gasienica-Kotelnicki on 01.06.17.
 */
@Service
public class MailSendingService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSendingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private void sendWithAttachment(Order order, SimpleMailMessage mail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getText());
            String pdfName = "invoice.pdf";
            FileSystemResource fileSystemResource = new FileSystemResource(pdfName);
            helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            javaMailSender.send(message);
            fileSystemResource.getFile().delete();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private SimpleMailMessage baseEmail(Order order) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(order.getUser().getEmail());
        mail.setFrom("simongk95@gmail.com");
        mail.setSubject("Bilet nr: " + order.getId());
        mail.setText("Witaj " + order.getUser().getName() + "bilet znajdziesz w załączniku.");
        return mail;
    }
}
