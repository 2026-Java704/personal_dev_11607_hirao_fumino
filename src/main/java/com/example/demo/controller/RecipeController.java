package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
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

	@Autowired
	private Account account;

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

		// 主キー検索 
		Recipe recipe = recipeRepository.findById(id).orElse(null);

		if (recipe == null) {
			return "redirect:/recipes";
		}
		model.addAttribute("recipe", recipe);

		// このレシピのコメント一覧を表示
		List<Comment> commentList = commentRepository.findByRecipeIdOrderByIdAsc(id);
		model.addAttribute("commentList", commentList);

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

	// コメント投稿
	@PostMapping("/recipes/detail/{id}/comment")
	public String addComment(
			@PathVariable Integer id,
			@RequestParam String content) {

		// 1. ログインチェック
		if (account == null || account.getEmail() == null) {
			return "redirect:/login";
		}

		// 空っぽのコメントは保存しない
		if (content == null || content.trim().isEmpty()) {
			return "redirect:/recipes/detail/" + id;
		}

		// 2. ログインしているユーザーの情報をデータベースから特定
		List<User> userList = userRepository.findByEmail(account.getEmail());
		if (userList == null || userList.isEmpty()) {
			return "redirect:/login";
		}
		User currentUser = userList.get(0);

		// 3. コメントデータを作って、リポジトリで保存する
		Comment comment = new Comment();
		comment.setRecipeId(id);
		comment.setUser(currentUser);
		comment.setContent(content);

		commentRepository.save(comment);

		return "redirect:/recipes/detail/" + id;
	}

	// 編集画面表示
	@GetMapping("/recipes/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {

		// 未ログインならログイン画面へ
		//		if (account.getId() == null) {
		//			return "login";
		//		}

		Recipe recipe = recipeRepository.findById(id).get();
		List<Category> categories = categoryRepository.findAll();

		// 投稿者とログインユーザーが一致しない場合は一覧に弾く
		//		if (!recipe.getUser().getId().equals(account.getId())) {
		//			return "redirect:/recipes";
		//		}

		model.addAttribute("recipe", recipe);
		model.addAttribute("categories", categories);

		return "recipesEdit";
	}

	// レシピの更新処理
	@PostMapping("/recipes/edit/{id}")
	public String update(
			@PathVariable Integer id,
			@RequestParam Integer categoryId,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String recipe) {

		//  未ログインチェック
		//		if (account.getId() == null) {
		//			return "login";
		//		}

		Recipe updateRecipe = recipeRepository.findById(id).get();

		//  投稿者チェック
		//		if (!updateRecipe.getUser().getId().equals(account.getId())) {
		//			return "redirect:/recipes";
		//		}

		Category category = categoryRepository.findById(categoryId).get();

		updateRecipe.setName(name);
		updateRecipe.setRecipe(recipe);
		updateRecipe.setCategory(category);

		recipeRepository.save(updateRecipe);

		return "redirect:/recipes";
	}

	// レシピを削除
	@PostMapping("/recipes/{id}/delete")
	public String delete(@PathVariable Integer id) {

		// 1. 未ログインチェック
		//		if (account.getId() == null) {
		//			return "login";
		//		}

		Recipe recipe = recipeRepository.findById(id).get();

		// 2. 投稿者チェック
		//		if (!recipe.getUser().getId().equals(account.getId())) {
		//			return "redirect:/recipes";
		//		}

		recipeRepository.deleteById(id);

		return "redirect:/recipes";
	}

	//レシピ投稿画面を表示
	@GetMapping("/recipes/add")
	public String create(Model model) {

		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "recipesAdd";
	}

	//レシピ投稿ボタンをクリック
	@PostMapping("/recipes/add")
	public String add(
			@RequestParam String name,
			@RequestParam String recipe,
			@RequestParam(required = false) Integer categoryId,
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

			List<Category> categories = categoryRepository.findAll();
			model.addAttribute("categories", categories);

			model.addAttribute("errorList", errorList);
			model.addAttribute("name", name);
			model.addAttribute("recipe", recipe);

			return "recipesAdd";
		}
		Recipe recipes = new Recipe(name, recipe);

		recipes.setName(recipes.getName());
		recipes.setRecipe(recipes.getRecipe());

		// 選択されたカテゴリーIDをセット
		if (categoryId != null) {
			Category category = categoryRepository.findById(categoryId).orElse(null);
			recipes.setCategory(category);
		}

		// ログイン中のユーザー情報をレシピにセットする
		if (account != null && account.getEmail() != null) {
			List<User> loggedInUser = userRepository.findByEmail(account.getEmail());
			if (loggedInUser != null && !loggedInUser.isEmpty()) {

				User currentUser = loggedInUser.get(0);

				recipes.setUser(currentUser);

			}
		}

		recipeRepository.save(recipes);

		return "redirect:/recipes";

	}

}
