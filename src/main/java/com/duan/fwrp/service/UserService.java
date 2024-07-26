package com.duan.fwrp.service;

import com.duan.fwrp.dao.UsersDAO;
import com.duan.fwrp.entity.Users;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UsersDAO usersDAO;

    // Constructor that instantiates UsersDAO
    public UserService() {
        this.usersDAO = new UsersDAO(); // Ensuring UsersDAO is never null
    }

    public UserService(UsersDAO usersDAO) {
    }

    public Users authenticate(String email, String password) throws SQLException {
        Users user = usersDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    public void registerUser(Users user) throws SQLException {
        usersDAO.addUser(user);
    }

    public boolean isEmailExists(String email) throws SQLException {
        return usersDAO.getUserByEmail(email) != null;
    }

    public void updateUser(Users user) throws SQLException {
        usersDAO.updateUser(user);
    }

    public void deleteUser(int userId) throws SQLException {
        usersDAO.deleteUser(userId);
    }

    public Users getUser(int userId) throws SQLException {
        return usersDAO.getUser(userId);
    }

    public List<Users> getAllUsers() throws SQLException {
        return usersDAO.getAllUsers();
    }
}
