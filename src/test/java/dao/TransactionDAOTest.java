package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.duan.fwrp.dao.TransactionDAO;
import com.duan.fwrp.entity.Transaction;
import com.duan.fwrp.entity.TransactionInventory;

import java.sql.SQLException;
import java.util.List;

class TransactionDAOTest {

    private TransactionDAO dao;

    @BeforeEach
    void setUp() {
        dao = new TransactionDAO();
    }

    @Test
    void testAddAndGetTransaction() throws SQLException {
        Transaction transaction = new Transaction(1, 1, 5);
        
        dao.addtransaction(transaction);
        
        List<TransactionInventory> transactions = dao.getAllClaimedFoodByUserId(1);
        assertFalse(transactions.isEmpty());
        // Further assertions can be added based on expected data
    }
}