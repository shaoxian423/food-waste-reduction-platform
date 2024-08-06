package com.duan.fwrp.dao;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetailerInventoryDAO {

    public void addInventory(RetailerInventory inventory) throws SQLException {
        String sql = "INSERT INTO retailer_inventory (retailer_id, item_name, quantity, expiry_date, price, discount_rate, location, is_surplus, is_for_donation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, inventory.getRetailerId());
            stmt.setString(2, inventory.getItemName());
            stmt.setInt(3, inventory.getQuantity());
            stmt.setDate(4, inventory.getExpiryDate());
            stmt.setDouble(5, inventory.getPrice());
            stmt.setDouble(6, inventory.getDiscountRate());
            stmt.setString(7, inventory.getLocation());
            stmt.setBoolean(8, inventory.isSurplus());
            stmt.setBoolean(9, inventory.isForDonation());
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
                        rs.getString("location"),
                        rs.getBoolean("is_surplus"),
                        rs.getBoolean("for_donation")
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
                        rs.getString("location"),
                        rs.getBoolean("is_surplus"),
                        rs.getBoolean("is_for_donation")
                );
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<RetailerInventory> getAllSurplusInventoriesById(int id) throws SQLException {
        List<RetailerInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory WHERE retailer_id = ? AND is_surplus = 1";
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
                        rs.getString("location"),
                        rs.getBoolean("is_surplus"),
                        rs.getBoolean("is_for_donation")
                );
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<RetailerInventory> getAllDonationInventoriesById(int id) throws SQLException {
        List<RetailerInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory WHERE retailer_id = ? AND is_for_donation = 1";
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
                        rs.getString("location"),
                        rs.getBoolean("is_surplus"),
                        rs.getBoolean("is_for_donation")
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
                            rs.getString("location"),
                            rs.getBoolean("is_surplus"),
                            rs.getBoolean("is_for_donation")
                    );
                }
            }
        }
        return null;
    }

    public void updateInventory(RetailerInventory inventory) throws SQLException {
        String sql = "UPDATE retailer_inventory SET item_name = ?, quantity = ?, expiry_date = ?, price = ?, discount_rate = ?, location = ?, is_surplus = ?, is_for_donation = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, inventory.getItemName());
            stmt.setInt(2, inventory.getQuantity());
            stmt.setDate(3, inventory.getExpiryDate());
            stmt.setDouble(4, inventory.getPrice());
            stmt.setDouble(5, inventory.getDiscountRate());
            stmt.setString(6, inventory.getLocation());
            stmt.setBoolean(7, inventory.isSurplus());
            stmt.setBoolean(8, inventory.isForDonation());
            stmt.setInt(9, inventory.getId());
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

    public void markIsDonationTrueById(int itemId) throws SQLException {
        String sql = "UPDATE retailer_inventory SET is_for_donation = 1 WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        }
    }

    public void deleteInventoryById(int itemId) throws SQLException {
        String sql = "DELETE FROM retailer_inventory WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        }
    }

    public List<RetailerInventory> getAllSurplusInventories() throws SQLException {
        List<RetailerInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory WHERE is_surplus = 1";
        try (Connection connection = DatabaseUtil.getConnection();){
            PreparedStatement stmt = connection.prepareStatement(sql);
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
                        rs.getString("location"),
                        rs.getBoolean("is_surplus"),
                        rs.getBoolean("is_for_donation")
                );
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<RetailerInventory> getAllDonationInventories() throws SQLException {
        List<RetailerInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory WHERE is_for_donation = 1";
        try (Connection connection = DatabaseUtil.getConnection();){
            PreparedStatement stmt = connection.prepareStatement(sql);
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
                        rs.getString("location"),
                        rs.getBoolean("is_surplus"),
                        rs.getBoolean("is_for_donation")
                );
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public int getQuantityById(int itemId) throws SQLException {
        int quantity = 0;
        String sql = "SELECT quantity FROM retailer_inventory WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
            }
        }
        return quantity;
    }
}
