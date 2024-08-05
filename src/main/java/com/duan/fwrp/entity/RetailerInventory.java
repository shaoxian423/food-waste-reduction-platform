package com.duan.fwrp.entity;

import java.sql.Date;

public class RetailerInventory {
    private int id;
    private int retailerId;
    private String itemName;
    private int quantity;
    private Date expiryDate;
    private double price;
    private double discountRate;
    private String location;
    private boolean isSurplus;
    private boolean isForDonation;

    public RetailerInventory(int id, int retailerId, String itemName, int quantity, Date expiryDate, double price, double discountRate, String location, boolean isSurplus, boolean isForDonation) {
        this.id = id;
        this.retailerId = retailerId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discountRate = discountRate;
        this.location = location;
        this.isSurplus = isSurplus;
        this.isForDonation = isForDonation;
    }

    public RetailerInventory(int retailerId, String itemName, int quantity, Date expiryDate, double price, double discountRate, String location, boolean isSurplus, boolean isForDonation) {
        this.retailerId = retailerId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discountRate = discountRate;
        this.location = location;
        this.isSurplus = isSurplus;
        this.isForDonation = isForDonation;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
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
        return isSurplus;
    }

    public void setSurplus(boolean isSurplus) {
        this.isSurplus = isSurplus;
    }

    public boolean isForDonation() { return isForDonation;}

    public void setForDonation(boolean isForDonation) {this.isForDonation = isForDonation;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}
}
