 package com.foodwaste.backend.repository;

import com.foodwaste.backend.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}