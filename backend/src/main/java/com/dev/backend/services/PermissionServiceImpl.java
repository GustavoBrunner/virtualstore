package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Permission;
import com.dev.backend.entities.Person;
import com.dev.backend.repositories.PermissionRepository;
import com.dev.backend.services.contracts.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;
    
    @Autowired
    public PermissionServiceImpl(PermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getAllPersonByPermissionId(Long permissionId) {
        return repository.getAllPersonById(permissionId);
    }

    @Override
    public List<Permission> getAll() {
        return repository.findAll();
    }

    @Override
    public Permission create(Permission entity) {
        entity.setInsertionDate(new Date());
        return repository.saveAndFlush(entity);
    }

    @Override
    public Permission update(Permission entity) {
        entity.setAtualizationDate(new Date());
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        Permission entity = repository.findById(id).get();
        if(!entity.equals(null)){
            repository.delete(entity);
        }
    }
    
}
