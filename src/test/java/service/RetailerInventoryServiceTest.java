package service;

import com.duan.fwrp.service.RetailerInventoryService;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RetailerInventoryServiceTest {

    @Test
    public void testAddItem() throws SQLException {
        RetailerInventoryService service = new RetailerInventoryService();
        assertDoesNotThrow(() -> {
            service.addItem(1, "Apple", 10, new java.sql.Date(System.currentTimeMillis()), 1.99, 0.10, "Location A", false, false);
        });
    }

    @Test
    public void testGetAllItems() throws SQLException {
        RetailerInventoryService service = new RetailerInventoryService();
        assertNotNull(service.getAllItems(1));
    }
}
