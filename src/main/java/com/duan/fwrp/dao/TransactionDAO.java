package com.duan.fwrp.dao;

import java.sql.*;
import com.duan.fwrp.entity.Transaction;
import com.duan.fwrp.util.DatabaseUtil;

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
}
