package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Category;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class RecipeController {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UserRepository userRepository;
	private final CommentRepository commentRepository;
	private User account;

	public RecipeController(
			CategoryRepository categoryRepository,
			RecipeRepository recipeRepository,
			UserRepository userRepository,
			CommentRepository commentRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
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

	//レシピ詳細画面を表示
	@GetMapping("/recipes/detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		// 主キー検索 (.get() の代わりに安全な orElse(null) を使用)
		Recipe recipe = recipeRepository.findById(id).orElse(null);
		if (recipe == null) {
			return "redirect:/recipes";
		}
		model.addAttribute("recipe", recipe);

		// このレシピのコメント一覧を表示
		List<Comment> commentList = commentRepository.findByRecipeIdOrderByIdAsc(id);
		model.addAttribute("comments", commentList);

		// ログイン中のユーザー情報を取得
		Integer loggedInUserId = null;
		boolean isBookmarked = false;

		if (account != null && account.getEmail() != null) {
			List<User> loggedInUser = userRepository.findByEmail(account.getEmail());
			if (loggedInUser != null && !loggedInUser.isEmpty()) {
				User currentUser = loggedInUser.get(0);
				loggedInUserId = currentUser.getId();

			}
		}
		return "recipesDetail";
	}

	//レシピ詳細画面でコメントをする
	@PostMapping("/recipes/detail/{id}/comment")
	@ResponseBody // 画面遷移せず、データ（JSON）だけをブラウザに返す魔法のタグ
	public Map<String, Object> addComment(
			@PathVariable Integer id,
			@RequestParam String content) {

		Map<String, Object> response = new HashMap<>();
		response.put("success", false);

		// コメントが空っぽじゃなければ保存処理をする
		if (content != null && content.trim().length() > 0) {
			if (account != null && account.getEmail() != null) {
				List<User> loggedInUser = userRepository.findByEmail(account.getEmail());
				if (loggedInUser != null && !loggedInUser.isEmpty()) {
					User currentUser = loggedInUser.get(0);

					// データベースに保存
					Comment comment = new Comment(id, currentUser, content);
					commentRepository.save(comment);

					// HTML側（JavaScript）に「投稿者の名前」と「内容」を即座に返す
					response.put("success", true);
					response.put("userName", currentUser.getName());
					response.put("content", content);
				}
			}
		}
		return response;
	}

	//レシピ編集画面を表示
	@GetMapping("/recipes/edit/{id}/")
	public String editForm(@PathVariable Integer id, Model model) {
		Recipe recipe = recipeRepository.findById(id).orElse(null);

		//投稿者以外は一覧画面にリダイレクト
		if (recipe == null || account == null || account.getEmail() == null) {
			return "redirect:/recipes";
		}
		List<User> loggedInUser = userRepository.findByEmail(account.getEmail());
		if (loggedInUser.isEmpty() || !recipe.getUserId().equals(loggedInUser.get(0).getId())) {
			return "redirect:/recipes";
		}

		model.addAttribute("recipe", recipe);
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		return "recipesEdit";
	}

	//編集したレシピを更新
	@PostMapping("/recipes/edit/{id}/")
	public String update(
			@PathVariable Integer id,
			@RequestParam String name,
			@RequestParam String recipe,
			@RequestParam(required = false) Integer categoryId) {

		Recipe existingRecipe = recipeRepository.findById(id).orElse(null);
		if (existingRecipe != null) {
			existingRecipe.setName(name);
			existingRecipe.setRecipe(recipe);

			if (categoryId != null) {
				Category category = categoryRepository.findById(categoryId).orElse(null);
				existingRecipe.setCategory(category);
			}
			recipeRepository.save(existingRecipe);
		}
		return "redirect:/recipes/detail/" + id;
	}

	//レシピを削除
	@PostMapping("/recipes/{id}/delete")
	public String delete(@PathVariable Integer id) {
		recipeRepository.deleteById(id);

		return "redirect:/recipes";
	}

	//レシピ投稿画面を表示
	@GetMapping("/recipes/add")
	public String create() {
		return "recipesAdd";
	}

	//レシピ投稿ボタンをクリック
	@PostMapping("/recipes/add")
	public String add(
			@RequestParam String name,
			@RequestParam String recipe,
			Model model) {

		List<String> errorList = new ArrayList<>();

		//レシピ名が空の場合エラー
		if (name.length() == 0) {
			errorList.add("レシピ名を入力して下さい");
		}
		//作り方が空の場合エラー
		if (recipe.length() == 0) {
			errorList.add("作り方を入力して下さい");
		}
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("name", name);
			model.addAttribute("recipe", recipe);

			return "recipesAdd";
		}
		Recipe recipes = new Recipe(name, recipe);

		recipes.setName(recipes.getName());
		recipes.setRecipe(recipes.getRecipe());

		recipeRepository.save(recipes);

		return "redirect:/recipes";

	}

}
