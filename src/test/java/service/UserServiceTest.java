//package service;
//
//import com.duan.fwrp.entity.Users;
//import com.duan.fwrp.dao.UsersDAO;
//import com.duan.fwrp.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserServiceTest {
//
//    private UserService userService;
//    private UsersDAO mockUsersDAO;
//
//    @BeforeEach
//    public void setUp() {
//        // Create a mock UsersDAO with stubbed methods
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public Users getUserByEmail(String email) throws SQLException {
//                return null; // Default behavior
//            }
//
//            @Override
//            public void addUser(Users user) throws SQLException {
//                // Default behavior
//            }
//
//            @Override
//            public void updateUser(Users user) throws SQLException {
//                // Default behavior
//            }
//
//            @Override
//            public void deleteUser(int userId) throws SQLException {
//                // Default behavior
//            }
//
//            @Override
//            public Users getUser(int userId) throws SQLException {
//                return null; // Default behavior
//            }
//
//            @Override
//            public List<Users> getAllUsers() throws SQLException {
//                return new ArrayList<>(); // Default behavior
//            }
//        };
//
//        // Initialize UserService with the mock UsersDAO
//        userService = new UserService(mockUsersDAO);
//    }
//
//    @Test
//    public void testAuthenticateSuccess() throws SQLException {
//        // Arrange
//        Users user = new Users();
//        user.setEmail("test@example.com");
//        user.setPassword("password");
//
//        // Override the stub behavior for this test
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public Users getUserByEmail(String email) throws SQLException {
//                if ("test@example.com".equals(email)) {
//                    return user;
//                }
//                return null;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        Users result = userService.authenticate("test@example.com", "password");
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("test@example.com", result.getEmail());
//    }
//
//    @Test
//    public void testAuthenticateFailure() throws SQLException {
//        // Arrange
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public Users getUserByEmail(String email) throws SQLException {
//                return null;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        Users result = userService.authenticate("test@example.com", "password");
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    public void testRegisterUser() throws SQLException {
//        // Arrange
//        Users user = new Users();
//        boolean[] called = {false};
//
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public void addUser(Users user) throws SQLException {
//                called[0] = true;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        userService.registerUser(user);
//
//        // Assert
//        assertTrue(called[0]);
//    }
//
//    @Test
//    public void testIsEmailExistsTrue() throws SQLException {
//        // Arrange
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public Users getUserByEmail(String email) throws SQLException {
//                return new Users(); // Simulate email exists
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        boolean exists = userService.isEmailExists("test@example.com");
//
//        // Assert
//        assertTrue(exists);
//    }
//
//    @Test
//    public void testIsEmailExistsFalse() throws SQLException {
//        // Arrange
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public Users getUserByEmail(String email) throws SQLException {
//                return null; // Simulate email does not exist
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        boolean exists = userService.isEmailExists("test@example.com");
//
//        // Assert
//        assertFalse(exists);
//    }
//
//    @Test
//    public void testUpdateUser() throws SQLException {
//        // Arrange
//        Users user = new Users();
//        boolean[] called = {false};
//
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public void updateUser(Users user) throws SQLException {
//                called[0] = true;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        userService.updateUser(user);
//
//        // Assert
//        assertTrue(called[0]);
//    }
//
//    @Test
//    public void testDeleteUser() throws SQLException {
//        // Arrange
//        int userId = 1;
//        boolean[] called = {false};
//
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public void deleteUser(int userId) throws SQLException {
//                called[0] = true;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        userService.deleteUser(userId);
//
//        // Assert
//        assertTrue(called[0]);
//    }
//
//    @Test
//    public void testGetUser() throws SQLException {
//        // Arrange
//        Users user = new Users();
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public Users getUser(int userId) throws SQLException {
//                return user;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        Users result = userService.getUser(1);
//
//        // Assert
//        assertNotNull(result);
//    }
//
//    @Test
//    public void testGetAllUsers() throws SQLException {
//        // Arrange
//        List<Users> usersList = new ArrayList<>();
//        mockUsersDAO = new UsersDAO() {
//            @Override
//            public List<Users> getAllUsers() throws SQLException {
//                return usersList;
//            }
//        };
//        userService = new UserService(mockUsersDAO);
//
//        // Act
//        List<Users> result = userService.getAllUsers();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(usersList, result);
//    }
//}