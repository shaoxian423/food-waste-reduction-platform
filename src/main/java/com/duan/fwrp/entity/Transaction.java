package com.duan.fwrp.entity;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private Timestamp timestamp;
    private int userId;
    private int inventoryId;
    private int quantity;

    public Transaction(int id, Timestamp timestamp, int userId, int inventoryId, int quantity) {
        this.id = id;
        this.timestamp = timestamp;
        this.userId = userId;
        this.inventoryId = inventoryId;
        this.quantity = quantity;
    }

    public Transaction(int userId, int inventoryId, int quantity) {
        this.userId = userId;
        this.inventoryId = inventoryId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
