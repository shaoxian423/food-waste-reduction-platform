package com.duan.fwrp.entity;

import java.time.LocalDate;

public class RetailerInventory {
    private int id;
    private int retailerId;
    private String name;
    private int quantity;
    private LocalDate expireDate;
    private double price;
    private double discountRate;

    public RetailerInventory(int id, int retailerId, String name, int quantity, LocalDate expireDate, double price, double discountRate) {
        this.id = id;
        this.retailerId = retailerId;
        this.name = name;
        this.quantity = quantity;
        this.expireDate = expireDate;
        this.price = price;
        this.discountRate = discountRate;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
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
}
