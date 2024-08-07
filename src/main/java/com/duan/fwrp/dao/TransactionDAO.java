package com.duan.fwrp.dao;

import java.sql.*;
import com.duan.fwrp.entity.Transaction;
import com.duan.fwrp.util.DatabaseUtil;
import com.duan.fwrp.entity.TransactionInventory;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Add a consumer transaction
    public void addtransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transaction(user_id, inventory_id, quantity) VALUES(?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, transaction.getUserId());
            preparedStatement.setInt(2, transaction.getInventoryId());
            preparedStatement.setInt(3, transaction.getQuantity());
            preparedStatement.executeUpdate();
        }
    }

    public List<TransactionInventory> getAllClaimedFoodByUserId(int id) throws SQLException{
        List<TransactionInventory> transactionInventories = new ArrayList<TransactionInventory>();
        String sql = "SELECT retailer_inventory.item_name, transaction.quantity, retailer_inventory.expiry_date, retailer_inventory.location, retailer_inventory.price, retailer_inventory.discount_rate, transaction.timestamp FROM transaction JOIN retailer_inventory ON(transaction.inventory_id =retailer_inventory.id) WHERE transaction.user_id=?";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TransactionInventory transactionInventory = new TransactionInventory(
                        rs.getString("item_name"),
                        rs.getInt("quantity"),
                        rs.getDate("expiry_date"),
                        rs.getDouble("price"),
                        rs.getDouble("discount_rate"),
                        rs.getString("location"),
                        rs.getTimestamp("timestamp")
                );
                transactionInventories.add(transactionInventory);
            }
        }
        return transactionInventories;
    }
}
