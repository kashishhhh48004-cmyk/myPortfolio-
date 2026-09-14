package com.kashishsharma.portfolio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*") // tighten this to your real domain before going live
public class ContactController {

    private final JavaMailSender mailSender;

    @Value("${portfolio.contact.to-address}")
    private String toAddress;

    public ContactController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping
    public Map<String, String> submit(@Valid @RequestBody ContactRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setReplyTo(request.getEmail());
        message.setSubject("Portfolio contact form: " + request.getName());
        message.setText(
            "Name: " + request.getName() + "\n" +
            "Email: " + request.getEmail() + "\n\n" +
            request.getMessage()
        );
        mailSender.send(message);
        return Map.of("status", "sent");
    }
}
