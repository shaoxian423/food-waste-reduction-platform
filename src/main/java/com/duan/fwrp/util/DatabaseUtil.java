package com.duan.fwrp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/fwrp";
    private static final String USER = "root";
    private static final String PASSWORD = "Password_1234";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Unable to load database driver", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
