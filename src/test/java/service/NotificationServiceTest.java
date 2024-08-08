package service;

import com.duan.fwrp.entity.Notification;
import com.duan.fwrp.service.NotificationService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    @Test
    public void testGetNewNotifications() {
        NotificationService service = new NotificationService();
        List<Notification> notifications = service.getNewNotifications();
        assertNotNull(notifications);
    }

    @Test
    public void testMarkAsProcessed() {
        NotificationService service = new NotificationService();
        List<Notification> notifications = List.of(new Notification());
        assertDoesNotThrow(() -> service.markAsProcessed(notifications));
    }
}
