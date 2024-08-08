package service;

import com.duan.fwrp.service.EmailSender;
import org.junit.jupiter.api.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EmailSenderTest {
    @Test
    void testSendEmail() {
        // Arrange
        String toEmail = "recipient@example.com";
        String subject = "Test Email";
        String body = "This is a test email.";

        // Act
        assertDoesNotThrow(() -> EmailSender.sendEmail(toEmail, subject, body));
    }
}