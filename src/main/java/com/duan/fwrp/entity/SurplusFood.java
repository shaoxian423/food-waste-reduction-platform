package com.duan.fwrp.entity;

public class SurplusFood {
    private int id;
    private int inventoryId;
    private boolean isForSale;
    private double discountPrice;

    public SurplusFood() {
    }

    public SurplusFood(int id, int inventoryId, boolean isForSale, double discountPrice) {
        this.id = id;
        this.inventoryId = inventoryId;
        this.isForSale = isForSale;
        this.discountPrice = discountPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
