package com.delivery.service;

import com.delivery.entity.Food;
import com.delivery.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        Optional<Food> food = foodRepository.findById(id);

        if (food.isEmpty()) {
            throw new RuntimeException("id에 해당하는 음식을 찾을 수 없습니다.  " + id);
        }

        return food.get();
    }

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Long id, Food updatedFood) {
        Optional<Food> optionalFood = foodRepository.findById(id);

        if (optionalFood.isEmpty()) {
            throw new RuntimeException("id에 해당하는 음식을 찾을 수 없습니다. " + id);
        }

        Food food = optionalFood.get();
        food.setName(updatedFood.getName());
        food.setPrice(updatedFood.getPrice());
        food.setCategory(updatedFood.getCategory());
        food.setDescription(updatedFood.getDescription());
        food.setImageUrl(updatedFood.getImageUrl());
        food.setQuantity(updatedFood.getQuantity());

        return foodRepository.save(food);
    }

    public void deleteFoodById(Long id) {
        Optional<Food> food = foodRepository.findById(id);

        if (food.isEmpty()) {
            throw new RuntimeException("id에 해당하는 음식을 찾을 수 없습니다. " + id);
        }

        foodRepository.deleteById(id);
    }
}
