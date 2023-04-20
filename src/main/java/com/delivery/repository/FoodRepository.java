package com.delivery.repository;

import com.delivery.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface FoodRepository extends JpaRepository<Food, Integer> {

=======
public interface FoodRepository extends JpaRepository<Food, Long> {
>>>>>>> origin/dev
}
