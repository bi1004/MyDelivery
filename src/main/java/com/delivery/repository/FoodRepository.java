package com.delivery.repository;

import com.delivery.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>{

    List<Food>findByName(String name);

    List<Food>findByNameOrDescription(String name, String description);

    List<Food>findByPriceLessThan(Integer price);

    List<Food> findByPriceLessThanOrderByPriceDesc(Integer price); //가격이 높은 순

    @Query("select f from Food f where f.description like " +
            "%:description% order by f.price desc")
    List<Food> findByDescription(@Param("description") String description);
    // 일부 문자열이 포함된 항목을 검색하며, 해당 항목들을 가격이 높은 순서대로 정렬하여 반환



}
