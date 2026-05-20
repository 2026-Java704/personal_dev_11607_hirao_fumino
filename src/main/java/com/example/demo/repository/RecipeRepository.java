package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	List<Recipe> findByCategoryId(Integer categoryId);

	List<Recipe> findByNameContaining(String keyword);

}
