package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer userId;

	private String name; //料理名

	private String recipe; //レシピ詳細

//	private String message; //コメント

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

//	public Recipe(String message) {
//		this.message = message;
//	}

	//ゲッターとセッター

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
//	public String getMessage() {
//		return message;
//	}
//	
//	public void setMessage(String message) {
//		this.message = message;
//	}
}
