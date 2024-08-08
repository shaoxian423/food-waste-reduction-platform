package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.duan.fwrp.dao.SubscriptionDAO;
import com.duan.fwrp.entity.UserSubscription;

import java.sql.SQLException;

class SubscriptionDAOTest {

    private SubscriptionDAO dao;

    @BeforeEach
    void setUp() {
        dao = new SubscriptionDAO();
    }

    @Test
    void testInsertSubscription() throws SQLException {
        UserSubscription subscription = new UserSubscription(1, "Test Location", "Test Preference");
        
        // This will throw an exception if insertion fails
        assertDoesNotThrow(() -> dao.insertSubscription(subscription));
    }
}