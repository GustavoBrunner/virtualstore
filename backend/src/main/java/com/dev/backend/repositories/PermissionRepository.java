package com.dev.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Permission;
import com.dev.backend.entities.Person;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    public List<Person> getAllPersonById(Long permissionId);
    public List<Permission> getByName(String name);
}
