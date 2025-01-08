package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> { }