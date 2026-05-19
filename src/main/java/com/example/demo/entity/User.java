package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 顧客ID

	private String email; // メールアドレス

	private String password;//パスワード

	// コンストラクタ
	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// ゲッター
	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
