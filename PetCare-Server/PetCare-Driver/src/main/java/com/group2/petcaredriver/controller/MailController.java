package com.group2.petcaredriver.controller;


import com.group2.petcaredriver.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
@RequestMapping(path = "v1/mail")
@Slf4j
@CrossOrigin
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping(value = "/confirm-mail")
    public ResponseEntity<String> sendConfirmMail(@RequestParam(name = "mail", required = true) String mail,
                                                  @RequestParam(name = "date", required = true) String date,
                                                  @RequestParam(name = "time", required = true) String time) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.office365.com");
        mailSender.setPort(587);

        mailSender.setUsername("hang.vtt183524@sis.hust.edu.vn");
        mailSender.setPassword("plgAYA99");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hang.vtt183524@sis.hust.edu.vn");
        message.setTo(mail);
        message.setSubject("Confirm Schedule");

        String confirmMailText = "Hello, " + mail
                + "<p>Your pet's schedule was accept by Hospital</p><br>"
                + "<p>Please arrive with your pet at: </p>"
                + "<br>"
                +"<p style=\"font-size:30px;\";>"
                + time + " on " + date
                +"</p>";
        message.setText(confirmMailText);

        mailSender.send(message);

        mailService.saveMail(mail, 1);
        return ResponseEntity.accepted().body("Confirm mail sent!");
    }

    @GetMapping(value = "/update-schedule-mail")
    public ResponseEntity<String> sendUpdateScheduleMail(@RequestParam(name = "mail", required = true) String mail,
                                                  @RequestParam(name = "date", required = true) String date,
                                                  @RequestParam(name = "time", required = true) String time) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.office365.com");
        mailSender.setPort(587);

        mailSender.setUsername("hang.vtt183524@sis.hust.edu.vn");
        mailSender.setPassword("plgAYA99");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hang.vtt183524@sis.hust.edu.vn");
        message.setTo(mail);
        message.setSubject("Confirm Schedule");

        String excuseText = "Hello, " + mail
                + "<p>Very sorry that your request at " + time + " on " + date + " cannot be met due to overload in Hospital</p><br>"
                + "<p>Please choose another time to arrive</p>";
        message.setText(excuseText);

        mailSender.send(message);

        mailService.saveMail(mail, 2);
        return ResponseEntity.accepted().body("Require re-time mail sent!");
    }
}
