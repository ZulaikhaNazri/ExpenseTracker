package com.SpringBootMVC.ExpensesTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootMVC.ExpensesTracker.entity.Category;

// Repository interface for managing Category entities in the expense tracker application.
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String category);
}
