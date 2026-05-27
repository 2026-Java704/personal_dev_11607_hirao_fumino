package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	private String name; //料理名

	private String recipe; //レシピ詳細

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	//コンストラクタ
	public Recipe() {

	}

	public Recipe(String name, String recipe) {
		this.name = name;
		this.recipe = recipe;
	}

	//ゲッターとセッター

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	//	public void setUser(User currentUser) {
	// TODO 自動生成されたメソッド・スタブ

	//	}

	//	public Category getUser() {
	// TODO 自動生成されたメソッド・スタブ
	//		return null;
	//	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
