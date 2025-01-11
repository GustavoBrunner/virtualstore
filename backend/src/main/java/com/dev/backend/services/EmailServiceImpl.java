package com.dev.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Email;
import com.dev.backend.services.contracts.EmailService;


@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}") 
    private String sender;
    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public String sendEmail(Email email) {
        try{

            Email newEmail = new Email(email.receiver(),  email.title(), email.message());
            
            SimpleMailMessage message= new SimpleMailMessage();
            message.setFrom(this.sender);
            message.setSentDate(new Date());
            message.setSubject(newEmail.title());
            message.setText(newEmail.message());
            message.setTo(newEmail.receiver()); 

            emailSender.send(message);
            return "Email sent: " + message.toString();
        } catch (Exception e){
            return "Error on sending the email"; 
        }
         
    }
    
}
