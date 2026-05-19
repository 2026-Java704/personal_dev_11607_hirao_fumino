package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>

List<Recipe> findByCategoryId(Integer categoryId);

List<Recipe> findByNameContaining(String keyword);

List<Recipe> findByNameContainingAndPriceLessThanEqual(String keyword, Integer maxPrice);
}


