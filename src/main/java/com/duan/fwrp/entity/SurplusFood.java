package com.duan.fwrp.entity;

import java.util.Date;

public class SurplusFood {
    private int id;
    private int inventoryId;
    private boolean isForSale;
    private double discountedPrice;
    private String itemName;
    private int quantity;
    private Date expiryDate;
    private double price;

    // Constructor
    public SurplusFood(int id, int inventoryId, boolean isForSale, double discountedPrice, String itemName, int quantity, Date expiryDate, double price) {
        this.id = id;
        this.inventoryId = inventoryId;
        this.isForSale = isForSale;
        this.discountedPrice = discountedPrice;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
