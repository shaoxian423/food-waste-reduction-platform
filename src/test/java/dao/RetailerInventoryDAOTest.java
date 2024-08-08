package dao;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

class RetailerInventoryDAOTest {

    private RetailerInventoryDAO dao;
    private RetailerInventory testInventory;

    @BeforeEach
    void setUp() {
        dao = new RetailerInventoryDAO();
        testInventory = new RetailerInventory(
                0, // ID will be assigned by the database
                1, // retailer_id
                "Test Item",
                200,
                Date.valueOf(LocalDate.now().plusDays(30)),
                15.99,
                0.1,
                "Test Location",
                false,
                false
        );
    }

    @Test
    void testAddAndGetInventory() throws SQLException {
        // Add the test inventory
        dao.addInventory(testInventory);

        // Get all inventories and check if the test inventory is there
        List<RetailerInventory> allInventories = dao.getAllRetailerInventories();
        assertTrue(allInventories.stream().anyMatch(inv -> inv.getItemName().equals("Test Item")));

        // Get the added inventory by retailer ID
        List<RetailerInventory> retailerInventories = dao.getAllRetailerInventoriesById(1);
        RetailerInventory addedInventory = retailerInventories.stream()
                .filter(inv -> inv.getItemName().equals("Test Item"))
                .findFirst()
                .orElse(null);

        assertNotNull(addedInventory);
        assertEquals(testInventory.getQuantity(), addedInventory.getQuantity());
        assertEquals(testInventory.getPrice(), addedInventory.getPrice());
    }

    @Test
    void testGetQuantityById() throws SQLException {
        // Add the test inventory
        dao.addInventory(testInventory);

        // Get the added inventory
        List<RetailerInventory> retailerInventories = dao.getAllRetailerInventoriesById(1);
        RetailerInventory addedInventory = retailerInventories.stream()
                .filter(inv -> inv.getItemName().equals("Test Item"))
                .findFirst()
                .orElse(null);

        assertNotNull(addedInventory);

        // Test getQuantityById
        int quantity = dao.getQuantityById(addedInventory.getId());
        assertEquals(testInventory.getQuantity(), quantity);
    }

    @AfterEach
    void tearDown() {
        // We're not deleting test data to avoid foreign key constraint issues
        // In a real-world scenario, you might want to use a test database or mock the DAO
    }
}