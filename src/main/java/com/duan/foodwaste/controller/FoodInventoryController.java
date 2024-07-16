package com.duan.foodwaste.controller;

import com.duan.foodwaste.entity.FoodInventory;
import com.duan.foodwaste.service.FoodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodInventories")
public class FoodInventoryController {
    @Autowired
    private FoodInventoryService foodInventoryService;

    @GetMapping
    public List<FoodInventory> getAllFoodInventories() {
        return foodInventoryService.getAllFoodInventories();
    }

    @PostMapping
    public FoodInventory saveFoodInventory(@RequestBody FoodInventory foodInventory) {
        return foodInventoryService.saveFoodInventory(foodInventory);
    }
}
