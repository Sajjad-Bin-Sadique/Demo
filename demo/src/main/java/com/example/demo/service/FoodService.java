package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;



@Service
public class FoodService {
	
	 @Autowired
	    private FoodRepository repository;

	    public Food saveFood(Food food) {
	        return repository.save(food);
	    }

	    public List<Food> saveFoods(List<Food> foods) {
	        return repository.saveAll(foods);
	    }

	    public List<Food> getFoods() {
	        return repository.findAll();
	    }

	    public Food getFoodById(int id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Food getFoodByName(String name) {
	        return repository.findByName(name);
	    }

	    public String deleteFood(int id) {
	        repository.deleteById(id);
	        return "product removed !! " + id;
	    }

	    public Food updateFood(Food food) {
	        Food existingFood = repository.findById(food.getId()).orElse(null);
	        existingFood.setName(food.getName());
	        existingFood.setPrice(food.getPrice());
	        existingFood.setStock(food.getStock());
	        return repository.save(existingFood);
	    }

}
