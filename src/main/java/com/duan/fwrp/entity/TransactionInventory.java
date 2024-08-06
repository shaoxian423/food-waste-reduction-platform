package com.duan.fwrp.entity;

import java.sql.Date;
import java.sql.Timestamp;
public class TransactionInventory {
    private String itemName;
    private int quantity;
    private Date expiryDate;
    private String location;
    private Timestamp timestamp;

    public TransactionInventory(String itemName, int quantity, Date expiryDate, String location, Timestamp timestamp) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.location = location;
        this.timestamp = timestamp;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
