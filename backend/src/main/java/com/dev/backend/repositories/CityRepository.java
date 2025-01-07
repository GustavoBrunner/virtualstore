package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{ }