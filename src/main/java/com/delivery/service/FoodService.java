package com.delivery.service;

import com.delivery.dto.FoodDto;
import com.delivery.entity.Food;
import com.delivery.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food createFood(FoodDto foodDto) {
        Food food = new Food();
        food.setName(foodDto.getName());
        food.setPrice(foodDto.getPrice());
        food.setCategory(foodDto.getCategory());
        food.setDescription(foodDto.getDescription());
        food.setQuantity(foodDto.getQuantity());
        return foodRepository.save(food);
    }

    public FoodDto getFoodById(int id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id에 해당하는 음식을 찾을 수 없습니다. " + id));
        return convertToDto(food);
    }

    public List<FoodDto> getAllFood() {
        List<Food> foods = foodRepository.findAll();
        return foods.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<FoodDto> searchFoodByName(String name) {
        List<Food> foods = foodRepository.findByName(name);
        return foods.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<FoodDto> searchFoodByNameOrDescription(String name, String description) {
        List<Food> foods = foodRepository.findByNameOrDescription(name, description);
        return foods.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<FoodDto> searchFoodByPriceLessThan(Integer price) {
        List<Food> foods = foodRepository.findByPriceLessThan(price);
        return foods.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<FoodDto> searchFoodByPriceLessThanOrderByPriceDesc(Integer price) {
        List<Food> foods = foodRepository.findByPriceLessThanOrderByPriceDesc(price);
        return foods.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<FoodDto> searchFoodByDescription(String description) {
        List<Food> foods = foodRepository.findByDescription(description);
        return foods.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public FoodDto updateFood(int id, FoodDto foodDto) {
        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id에 해당하는 음식을 찾을 수 없습니다. " + id));
        existingFood.setName(foodDto.getName());
        existingFood.setPrice(foodDto.getPrice());
        existingFood.setCategory(foodDto.getCategory());
        existingFood.setDescription(foodDto.getDescription());
        existingFood.setQuantity(foodDto.getQuantity());
        return convertToDto(foodRepository.save(existingFood));
    }

    public void deleteFood(int id) {
        foodRepository.deleteById(id);
    }

    private FoodDto convertToDto(Food food) {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setPrice(food.getPrice());
        foodDto.setCategory(food.getCategory());
        foodDto.setDescription(food.getDescription());
        foodDto.setQuantity(food.getQuantity());
        return foodDto;
    }
}
