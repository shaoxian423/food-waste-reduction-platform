package com.duan.fwrp.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DatabaseUtil {

    private static DatabaseUtil databaseUtil;
    private static Connection connection = null;
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    public static Connection getConnection() {
        Properties properties = new Properties();
        try(InputStream in = DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(in);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
        }catch(IOException e) {
            e.printStackTrace();
        }
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException f){
            f.printStackTrace();
        }
        return connection;
    }
}
