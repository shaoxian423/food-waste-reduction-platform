package com.duan.fwrp.dao;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RetailerInventoryDAO {
    public void addInventory(RetailerInventory item) throws SQLException {
        String query = "INSERT INTO Retailer_Inventory (id, retailer_id, name, quantity, expire_date, price, discount_rate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, item.getId());
            stmt.setInt(2, item.getRetailerId());
            stmt.setString(3, item.getName());
            stmt.setInt(4, item.getQuantity());
            stmt.setDate(5, Date.valueOf(item.getExpireDate())); // LocalDate to java.sql.Date
            stmt.setDouble(6, item.getPrice());
            stmt.setDouble(7, item.getDiscountRate());
            stmt.executeUpdate();
        }
    }

    public List<RetailerInventory> getAllInventory() throws SQLException {
        List<RetailerInventory> inventoryList = new ArrayList<>();
        String query = "SELECT * FROM Retailer_Inventory";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int retailerId = rs.getInt("retailer_id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                LocalDate expireDate = rs.getDate("expire_date").toLocalDate(); // java.sql.Date to LocalDate
                double price = rs.getDouble("price");
                double discountRate = rs.getDouble("discount_rate");

                RetailerInventory item = new RetailerInventory(id, retailerId, name, quantity, expireDate, price, discountRate);
                inventoryList.add(item);
            }
        }
        return inventoryList;
    }
}
