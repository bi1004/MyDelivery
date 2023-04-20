package com.delivery.controller;

import com.delivery.entity.Food;
import com.delivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/")
=======
@RequestMapping("/foods")
>>>>>>> origin/dev
public class FoodController {
    @Autowired
    private FoodService foodService;

<<<<<<< HEAD
    @GetMapping("/foods")
=======
    @GetMapping
>>>>>>> origin/dev
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<Food> getFoodById(@PathVariable Integer id) {
=======
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
>>>>>>> origin/dev
        Food food = foodService.getFoodById(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food newFood = foodService.addFood(food);
        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
<<<<<<< HEAD
=======

>>>>>>> origin/dev
    }
}