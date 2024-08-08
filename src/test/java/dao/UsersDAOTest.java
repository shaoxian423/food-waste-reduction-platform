package dao;

import com.duan.fwrp.dao.UsersDAO;
import com.duan.fwrp.entity.Users;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

public class UsersDAOTest {

    private UsersDAO usersDAO;
    private Users testUser;

    @BeforeEach
    public void setUp() {
        usersDAO = new UsersDAO();
        testUser = new Users();
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        testUser.setPassword("password123");
        testUser.setPhone("1234567890");
        testUser.setCommunicationMethod("email");
        testUser.setUserType("consumer");
    }

    @Test
    public void testAddUserAndGetUserByEmail() throws SQLException {
        // Add the test user
        usersDAO.addUser(testUser);

        // Retrieve the user by email
        Users retrievedUser = usersDAO.getUserByEmail("test@example.com");

        // Assert that the retrieved user is not null
        assertNotNull(retrievedUser);

        // Assert that the retrieved user's details match the test user
        assertEquals(testUser.getName(), retrievedUser.getName());
        assertEquals(testUser.getEmail(), retrievedUser.getEmail());
        assertEquals(testUser.getPhone(), retrievedUser.getPhone());
        assertEquals(testUser.getCommunicationMethod(), retrievedUser.getCommunicationMethod());
        assertEquals(testUser.getUserType(), retrievedUser.getUserType());
    }

    @AfterEach
    public void tearDown() throws SQLException {
        // Clean up: delete the test user
        Users userToDelete = usersDAO.getUserByEmail("test@example.com");
        if (userToDelete != null) {
            usersDAO.deleteUser(userToDelete.getId());
        }
    }
}