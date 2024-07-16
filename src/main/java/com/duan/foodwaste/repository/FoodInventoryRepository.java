package com.duan.foodwaste.repository;

import com.duan.foodwaste.entity.FoodInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodInventoryRepository extends JpaRepository<FoodInventory, Long> {
}
