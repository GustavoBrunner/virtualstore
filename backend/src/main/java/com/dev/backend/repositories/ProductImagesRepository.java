package com.dev.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.ProductImages;

public interface ProductImagesRepository extends JpaRepository< ProductImages, Long > { 
    public List<ProductImages> getAllByProductId(Long productId);
}