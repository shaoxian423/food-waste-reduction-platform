package com.duan.fwrp.service;

import com.duan.fwrp.entity.Transaction;
import com.duan.fwrp.dao.TransactionDAO;
import java.sql.SQLException;

public class TransactionService {

    private TransactionDAO transactionDAO;

    public TransactionService() throws SQLException {
        transactionDAO = new TransactionDAO();
    }

    public void addTransaction(int userId, int inventoryId, int quantity) throws SQLException{
        Transaction transaction = new Transaction(userId, inventoryId, quantity);
        transactionDAO.addtransaction(transaction);
    }
}
