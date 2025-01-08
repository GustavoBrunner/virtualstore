package com.dev.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    public List<Person> getAllByCityId(Long cityId);
}
