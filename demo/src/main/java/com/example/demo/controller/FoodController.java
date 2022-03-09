package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Food;
import com.example.demo.service.FoodService;

;

@RestController
public class FoodController {

	@Autowired
    private FoodService service;

    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food) {
        return service.saveFood(food);
    }

    @PostMapping("/addFoods")
    public List<Food> addFoods(@RequestBody List<Food> foods) {
        return service.saveFoods(foods);
    }

    @GetMapping("/foods")
    public List<Food> findAllFoods() {
        return service.getFoods();
    }

    @GetMapping("/foodById/{id}")
    public Food findFoodById(@PathVariable int id) {
        return service.getFoodById(id);
    }

    @GetMapping("/food/{name}")
    public Food findFoodByName(@PathVariable String name) {
        return service.getFoodByName(name);
    }

    @PutMapping("/update")
    public Food updateFood(@RequestBody Food food) {
        return service.updateFood(food);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFood(@PathVariable int id) {
        return service.deleteFood(id);
    }
}
