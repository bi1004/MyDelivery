package com.delivery.controller;

import com.delivery.entity.Food;
import com.delivery.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    // GET 요청에 대한 처리
    @GetMapping
    public ResponseEntity<List<Food>> getFoods() {
        List<Food> foods = foodRepository.findAll();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    // GET 요청에 대한 처리 (특정 음식 이름 검색)
    @GetMapping("/{name}")
    public ResponseEntity<List<Food>> getFoodsByName(@PathVariable String name) {
        List<Food> foods = foodRepository.findByName(name);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    // POST 요청에 대한 처리
    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food newFood = foodRepository.save(food);
        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }

    // PUT 요청에 대한 처리
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable int id, @RequestBody Food food) {
        Food updatedFood = foodRepository.findById(id).orElse(null);
        if (updatedFood == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedFood.setName(food.getName());
        updatedFood.setPrice(food.getPrice());
        updatedFood.setCategory(food.getCategory());
        updatedFood.setDescription(food.getDescription());
        updatedFood.setQuantity(food.getQuantity());
        Food savedFood = foodRepository.save(updatedFood);
        return new ResponseEntity<>(savedFood, HttpStatus.OK);
    }

    // DELETE 요청에 대한 처리
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFood(@PathVariable int id) {
        Food food = foodRepository.findById(id).orElse(null);
        if (food == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        foodRepository.delete(food);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}