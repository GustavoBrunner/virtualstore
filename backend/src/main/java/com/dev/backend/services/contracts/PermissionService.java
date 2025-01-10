package com.dev.backend.services.contracts;

import java.util.List;

import com.dev.backend.entities.Permission;
import com.dev.backend.entities.Person;

public interface PermissionService {
    public List<Person> getAllPersonByPermissionId(Long permissionId);
    public List<Permission> getAll();
    public Permission create(Permission entity);
    public Permission update(Permission entity);
    public void delete(Long id);
}
