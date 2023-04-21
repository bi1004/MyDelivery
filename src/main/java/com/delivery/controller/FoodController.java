package com.delivery.controller;

import com.delivery.entity.Food;
import com.delivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/foods/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Integer id) {
        Food food = foodService.getFoodById(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PostMapping("/foods")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food newFood = foodService.addFood(food);
        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }
}