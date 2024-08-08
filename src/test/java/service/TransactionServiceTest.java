package service;

import com.duan.fwrp.service.TransactionService;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionServiceTest {

    @Test
    public void testAddTransaction() throws SQLException {
        TransactionService service = new TransactionService();
        assertDoesNotThrow(() -> {
            service.addTransaction(1, 1, 5);
        });
    }

    @Test
    public void testGetAllClaimedFoodByUserId() throws SQLException {
        TransactionService service = new TransactionService();
        assertNotNull(service.getAllClaimedFoodByUserId(1));
    }
}
