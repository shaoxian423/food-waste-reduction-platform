package service;

import com.duan.fwrp.service.UserSubscriptionService;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserSubscriptionServiceTest {

    @Test
    public void testAddSubscription() throws SQLException {
        UserSubscriptionService service = new UserSubscriptionService();
        assertDoesNotThrow(() -> {
            service.addSubscription(1, "Location A", "Vegetables");
        });
    }
}
