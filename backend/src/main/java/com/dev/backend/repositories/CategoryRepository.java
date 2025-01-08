package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
