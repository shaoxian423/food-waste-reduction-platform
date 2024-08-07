package com.duan.fwrp.service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 587; // Use 465 for SSL
    private static final String FROM = "fwrp4971@gmail.com"; // Replace with your Gmail address
    private static final String USERNAME = "fwrp4971@gmail.com"; // Replace with your Gmail address
    private static final String PASSWORD = "fwrpPassword"; // Replace with your Gmail password or app password

    public void sendEmail(String toEmail, String subject, String body) {
        // Gmail SMTP server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // For TLS

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the sender address
            message.setFrom(new InternetAddress(FROM));

            // Set the recipient address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Set the subject and body of the email
            message.setSubject(subject);
            message.setText(body);

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
