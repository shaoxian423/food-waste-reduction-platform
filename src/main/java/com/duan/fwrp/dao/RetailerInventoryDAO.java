package com.duan.fwrp.dao;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetailerInventoryDAO {

    public void addInventory(RetailerInventory inventory) throws SQLException {
        String sql = "INSERT INTO retailer_inventory (retailer_id, item_name, quantity, expiry_date, price, discount_rate, is_surplus) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, inventory.getRetailerId());
            stmt.setString(2, inventory.getItemName());
            stmt.setInt(3, inventory.getQuantity());
            stmt.setDate(4, inventory.getExpiryDate());
            stmt.setDouble(5, inventory.getPrice());
            stmt.setDouble(6, inventory.getDiscountRate());
            stmt.setBoolean(7, inventory.isSurplus());
            stmt.executeUpdate();
        }
    }

    public List<RetailerInventory> getAllRetailerInventories() throws SQLException {
        List<RetailerInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RetailerInventory inventory = new RetailerInventory(
                        rs.getInt("id"),
                        rs.getInt("retailer_id"),
                        rs.getString("item_name"),
                        rs.getInt("quantity"),
                        rs.getDate("expiry_date"),
                        rs.getDouble("price"),
                        rs.getDouble("discount_rate"),
                        rs.getBoolean("is_surplus")
                );
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<RetailerInventory> getAllRetailerInventoriesById(int id) throws SQLException{
        List<RetailerInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory WHERE retailer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RetailerInventory inventory = new RetailerInventory(
                        rs.getInt("id"),
                        rs.getInt("retailer_id"),
                        rs.getString("item_name"),
                        rs.getInt("quantity"),
                        rs.getDate("expiry_date"),
                        rs.getDouble("price"),
                        rs.getDouble("discount_rate"),
                        rs.getBoolean("is_surplus")
                );
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public RetailerInventory getInventoryById(int itemId) throws SQLException {
        String sql = "SELECT * FROM retailer_inventory WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new RetailerInventory(
                            rs.getInt("id"),
                            rs.getInt("retailer_id"),
                            rs.getString("item_name"),
                            rs.getInt("quantity"),
                            rs.getDate("expiry_date"),
                            rs.getDouble("price"),
                            rs.getDouble("discount_rate"),
                            rs.getBoolean("is_surplus")
                    );
                }
            }
        }
        return null;
    }

    public void updateInventory(RetailerInventory inventory) throws SQLException {
        String sql = "UPDATE retailer_inventory SET item_name = ?, quantity = ?, expiry_date = ?, price = ?, discount_rate = ?, is_surplus = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, inventory.getItemName());
            stmt.setInt(2, inventory.getQuantity());
            stmt.setDate(3, inventory.getExpiryDate());
            stmt.setDouble(4, inventory.getPrice());
            stmt.setDouble(5, inventory.getDiscountRate());
            stmt.setBoolean(6, inventory.isSurplus());
            stmt.setInt(7, inventory.getId());
            stmt.executeUpdate();
        }
    }

    public void markIsSurplusTrueById(int itemId) throws SQLException {
        String sql = "UPDATE retailer_inventory SET is_surplus = 1 WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        }
    }
}
