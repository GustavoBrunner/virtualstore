package com.dev.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  { 
    public List<Product> getAllByBrandId(Long brandId);
}