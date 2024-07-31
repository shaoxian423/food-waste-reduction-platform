package com.duan.fwrp.dao;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RetailerInventoryDAO {
    private Connection connection;

    public RetailerInventoryDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }

    public void save(RetailerInventory item) {
        try {
            String query = "INSERT INTO Inventory (retailerId, itemName, quantity, expiryDate, price, discountRate) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, item.getRetailerId());
            pstmt.setString(2, item.getItemName());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setString(4, item.getExpiryDate());
            pstmt.setDouble(5, item.getPrice());
            pstmt.setDouble(6, item.getDiscountRate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RetailerInventory> findAll() {
        List<RetailerInventory> items = new ArrayList<>();
        try {
            String query = "SELECT * FROM Inventory";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RetailerInventory item = new RetailerInventory(
                        rs.getString("retailerId"),
                        rs.getString("itemName"),
                        rs.getInt("quantity"),
                        rs.getString("expiryDate"),
                        rs.getDouble("price"),
                        rs.getDouble("discountRate")
                );
                item.setId(rs.getString("id"));
                item.setSurplus(rs.getBoolean("surplus"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public RetailerInventory findById(String itemId) {
        RetailerInventory item = null;
        try {
            String query = "SELECT * FROM Inventory WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, itemId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                item = new RetailerInventory(
                        rs.getString("retailerId"),
                        rs.getString("itemName"),
                        rs.getInt("quantity"),
                        rs.getString("expiryDate"),
                        rs.getDouble("price"),
                        rs.getDouble("discountRate")
                );
                item.setId(rs.getString("id"));
                item.setSurplus(rs.getBoolean("surplus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void update(RetailerInventory item) {
        try {
            String query = "UPDATE Inventory SET retailerId = ?, itemName = ?, quantity = ?, expiryDate = ?, price = ?, discountRate = ?, surplus = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, item.getRetailerId());
            pstmt.setString(2, item.getItemName());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setString(4, item.getExpiryDate());
            pstmt.setDouble(5, item.getPrice());
            pstmt.setDouble(6, item.getDiscountRate());
            pstmt.setBoolean(7, item.isSurplus());
            pstmt.setString(8, item.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RetailerInventory> getAllRetailerInventories() {
        return findAll();
    }
}
