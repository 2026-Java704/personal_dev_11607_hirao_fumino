package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Recipe;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RecipeRepository;

import aQute.bnd.annotation.headers.Category;

@Controller
public class RecipeContoroller {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;

	public RecipeContoroller(
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
		if (categoryId != null) {
			// itemsテーブルをカテゴリーIDを指定して一覧を取得
			recipeList = recipeRepository.findByCategoryId(categoryId);
		} else {
			if (keyword.length() > 0) {
				//キーワードあり

			} else {

				model.addAttribute("keyword", keyword);
				model.addAttribute("items", recipeList);

			}
			return "recipes";
		}
	}

	//商品詳細画面
	@GetMapping("/items/{id}")
	public String show(
			@PathVariable Integer id,
			Model model) {
		//主キー検索
		Recipe recipe = recipeRepository.findById(id).get();
		model.addAttribute("recipe", recipe);

		return "recipeDetail";

	}

}
