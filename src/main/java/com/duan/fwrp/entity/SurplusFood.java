package com.duan.fwrp.entity;

import java.util.Date;

public class SurplusFood {
    private int id;
    private int inventoryId;
    private double discountedPrice;

    // Constructor
    public SurplusFood(int id, int inventoryId, boolean isForSale, double discountedPrice, String itemName, int quantity, Date expiryDate, double price) {
        this.id = id;
        this.inventoryId = inventoryId;
        this.discountedPrice = discountedPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

}
