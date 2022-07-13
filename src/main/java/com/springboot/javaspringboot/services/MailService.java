package com.springboot.javaspringboot.services;

import com.springboot.javaspringboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(User user/*, File file*/) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("mr.java2022@gmail.com");
            helper.setTo(user.getEmail());
            helper.setText(
                    "Please click the <a href='http://localhost:8080/users/activateAccount/" + user.getId() + "'>activation link</a>",
                    true);
//            helper.addAttachment("FileName", file);

        } catch (MessagingException exception) {
            exception.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
