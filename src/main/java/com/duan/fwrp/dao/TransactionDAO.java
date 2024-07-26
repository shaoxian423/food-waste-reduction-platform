package com.duan.fwrp.dao;

import com.duan.fwrp.entity.ConsumerTransaction;
import com.duan.fwrp.entity.CharityTransaction;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Add a consumer transaction
    public void addConsumerTransaction(ConsumerTransaction transaction) throws SQLException {
        String sql = "INSERT INTO Consumer_Transaction (consumer_id, inventory_id, quantity, expire_date, price, discount_rate) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getConsumerId());
            stmt.setInt(2, transaction.getInventoryId());
            stmt.setInt(3, transaction.getQuantity());
            stmt.setDate(4, new java.sql.Date(transaction.getExpireDate().getTime()));
            stmt.setDouble(5, transaction.getPrice());
            stmt.setDouble(6, transaction.getDiscountRate());
            stmt.executeUpdate();
        }
    }

    // Add a charity transaction
    public void addCharityTransaction(CharityTransaction transaction) throws SQLException {
        String sql = "INSERT INTO Charity_Transaction (charity_id, inventory_id, quantity, expire_date, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getCharityId());
            stmt.setInt(2, transaction.getInventoryId());
            stmt.setInt(3, transaction.getQuantity());
            stmt.setDate(4, new java.sql.Date(transaction.getExpireDate().getTime()));
            stmt.setDouble(5, transaction.getPrice());
            stmt.executeUpdate();
        }
    }

    // Get consumer transactions by consumer ID
    public List<ConsumerTransaction> getConsumerTransactions(int consumerId) throws SQLException {
        String sql = "SELECT * FROM Consumer_Transaction WHERE consumer_id = ?";
        List<ConsumerTransaction> transactions = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consumerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ConsumerTransaction transaction = new ConsumerTransaction();
                transaction.setId(rs.getInt("id"));
                transaction.setConsumerId(rs.getInt("consumer_id"));
                transaction.setInventoryId(rs.getInt("inventory_id"));
                transaction.setQuantity(rs.getInt("quantity"));
                transaction.setExpireDate(rs.getDate("expire_date"));
                transaction.setPrice(rs.getDouble("price"));
                transaction.setDiscountRate(rs.getDouble("discount_rate"));
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    // Get charity transactions by charity ID
    public List<CharityTransaction> getCharityTransactions(int charityId) throws SQLException {
        String sql = "SELECT * FROM Charity_Transaction WHERE charity_id = ?";
        List<CharityTransaction> transactions = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, charityId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CharityTransaction transaction = new CharityTransaction();
                transaction.setId(rs.getInt("id"));
                transaction.setCharityId(rs.getInt("charity_id"));
                transaction.setInventoryId(rs.getInt("inventory_id"));
                transaction.setQuantity(rs.getInt("quantity"));
                transaction.setExpireDate(rs.getDate("expire_date"));
                transaction.setPrice(rs.getDouble("price"));
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
