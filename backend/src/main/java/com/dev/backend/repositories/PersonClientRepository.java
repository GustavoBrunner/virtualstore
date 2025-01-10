package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Person;

public interface PersonClientRepository extends JpaRepository<Person, Long> { }