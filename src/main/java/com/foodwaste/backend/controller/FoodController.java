package com.foodwaste.backend.controller;
import com.foodwaste.backend.model.Food;
import com.foodwaste.backend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    // GET ALL
    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    // ADD FOOD
    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }

    // DELETE FOOD
    @DeleteMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable int id) {

        if (!foodRepository.existsById(id)) {
            return "Food not found";
        }

        foodRepository.deleteById(id);
        return "Deleted successfully";
    }
}