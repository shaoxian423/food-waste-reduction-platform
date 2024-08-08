package util;

import com.duan.fwrp.util.DatabaseUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {

    private Connection connection;

    @BeforeEach
    public void setUp() {
        // Initialize the connection before each test
        connection = DatabaseUtil.getConnection();
    }

    @AfterEach
    public void tearDown() {
        // Clean up after each test
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testConnectionNotNull() {
        assertNotNull(connection, "Connection should not be null");
    }

    @Test
    public void testConnectionIsValid() {
        try {
            assertTrue(connection.isValid(2), "Connection should be valid");
        } catch (SQLException e) {
            fail("SQLException was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testConnectionClosed() {
        try {
            connection.close();
            assertTrue(connection.isClosed(), "Connection should be closed");
        } catch (SQLException e) {
            fail("SQLException was thrown: " + e.getMessage());
        }
    }
}
