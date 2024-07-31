package com.duan.foodwaste.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "food_inventory")
public class FoodInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    // Getters and setters
}
