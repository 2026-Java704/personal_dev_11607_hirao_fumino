package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	private final HttpSession session;
	private final Account account;
	@Autowired
	private UserRepository userRepository;

	public UserController(
			HttpSession session,
			Account account,
			UserRepository userRepository) {
		this.session = session;
		this.account = account;
		this.userRepository = userRepository;
	}

	// ログイン画面を表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index() {
		// セッション情報を全てクリアする
		session.invalidate();

		return "login";
	}

	// ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam String email,
			@RequestParam String password,
			Model model) {
		//空の場合にエラーとする
		if (email.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");

			return "login";
		}
		List<User> userList = userRepository.findByEmailAndPassword(email, password);
		if (userList == null || userList.size() == 0) {
			//存在しなかった場合
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}
		User user = userList.get(0);

		//		// セッション管理されたアカウント情報にemailをセット
		account.setEmail(user.getEmail());

		// 「/recipes」へのリダイレクト
		return "redirect:/recipes";
	}

	//新規登録画面に移動
	@GetMapping("/users/new")
	public String create() {
		return "AccountForm";
	}

	//新規会員登録を実行
	@PostMapping("/users/add")
	public String store(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		List<String> errorList = new ArrayList<>();

		//名前が空の場合エラー
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		}
		//メールアドレスが空の場合エラー
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
			//パスワードが空の場合エラー
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
			//登録済みメールアドレスの場合エラー
		}
		List<User> userList = userRepository.findByEmail(email);
		if (userList != null && userList.size() > 0) {
			errorList.add("登録済みのメールアドレスです");
		}
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("name", name);
			model.addAttribute("email", email);
			model.addAttribute("password", password);
			return "AccountForm";
		}
		User user = new User(name, email, password);
		userRepository.save(user);

		return "redirect:/login";
	}
}