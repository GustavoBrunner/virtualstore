package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.PersonPermission;

public interface PersonPermissionRepository extends JpaRepository<PersonPermission, Long> { }
