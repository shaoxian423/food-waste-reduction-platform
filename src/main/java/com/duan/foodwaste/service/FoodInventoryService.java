package com.duan.foodwaste.service;

import com.duan.foodwaste.entity.FoodInventory;
import com.duan.foodwaste.repository.FoodInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodInventoryService {
    @Autowired
    private FoodInventoryRepository foodInventoryRepository;

    public List<FoodInventory> getAllFoodInventories() {
        return foodInventoryRepository.findAll();
    }

    public FoodInventory saveFoodInventory(FoodInventory foodInventory) {
        return foodInventoryRepository.save(foodInventory);
    }
}
