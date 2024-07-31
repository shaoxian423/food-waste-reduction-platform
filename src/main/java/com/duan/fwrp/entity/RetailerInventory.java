package com.duan.fwrp.entity;

public class RetailerInventory {
    private String id;
    private String retailerId;
    private String itemName;
    private int quantity;
    private String expiryDate;
    private double price;
    private double discountRate;
    private boolean surplus;

    // Constructors, getters, and setters

    public RetailerInventory(String retailerId, String itemName, int quantity, String expiryDate, double price, double discountRate) {
        this.retailerId = retailerId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discountRate = discountRate;
        this.surplus = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public boolean isSurplus() {
        return surplus;
    }

    public void setSurplus(boolean surplus) {
        this.surplus = surplus;
    }
}
