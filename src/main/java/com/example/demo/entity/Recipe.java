package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //レシピのID

	@Column(name = "user_id")
	private Integer userId; // ユーザーID

	private String name; // レシピ名

	private String recipes; //レシピ

	@

	public Integer getId() {
		return id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}
}

//package com.example.demo.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "recipes")
//public class Recipe {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	@Column(name = "user_id")
//	private Integer userId; // ユーザーID
//
//	@ManyToOne
//	@JoinColumn(name = "category_id")
//	private Category category; //カテゴリーID
//
//	private String name; // レシピ名
//
//	private String recipes; //レシピ
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getRecipes() {
//		return recipes;
//	}
//
//	public void setRecipes(String recipes) {
//		this.recipes = recipes;
//	}
//
//}
