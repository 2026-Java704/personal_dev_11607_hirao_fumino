package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aQute.bnd.annotation.headers.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
