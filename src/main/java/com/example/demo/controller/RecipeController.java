package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RecipeRepository;

@Controller
public class RecipeController {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;

	public RecipeController(
			CategoryRepository categoryRepository,
			RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
	}

	// レシピ一覧表示
	@GetMapping("/recipes")
	public String index(
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String keyword,
			Model model) {

		// 全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// 商品一覧情報の取得
		List<Recipe> recipeList = null;

		//キーワード検索
		if (keyword.length() > 0) {
			recipeList = recipeRepository.findByNameContaining(keyword);
		}
		//カテゴリーIdを指定して一覧を取得
		else if (categoryId != null) {
			recipeList = recipeRepository.findByCategory_Id(categoryId);
		} else {
			//全商品一覧
			recipeList = recipeRepository.findAll();
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("recipes", recipeList);

		return "recipes";

	}

	//レシピ詳細画面
	@GetMapping("/recipes/detail/{id}")
	public String detail(
			@PathVariable Integer id,
			Model model) {
		//主キー検索
		Recipe recipe = recipeRepository.findById(id).get();
		model.addAttribute("recipe", recipe);

		return "recipesDetail";
	}

	//レシピ投稿画面を表示
	@GetMapping("/recipes/add")
	public String create(
			@RequestParam(defaultValue = "") Integer userId,
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String recipeDetail,
			Model model);

}
