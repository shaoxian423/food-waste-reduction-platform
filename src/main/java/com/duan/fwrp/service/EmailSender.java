package com.duan.fwrp.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailSender {

    private static final String API_KEY = "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"; // Replace with your SendGrid API key

    public static void sendEmail(String toEmail, String subject, String body) {
        Email from = new Email("fwrp4971@gmail.com"); // Replace with your verified sender email
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(API_KEY);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Email sent successfully! Status Code: " + response.getStatusCode());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        sendEmail("recipient@example.com", "Test Subject", "This is a test email body.");
    }
}
