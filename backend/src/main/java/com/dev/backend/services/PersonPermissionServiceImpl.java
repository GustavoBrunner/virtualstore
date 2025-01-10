package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.backend.entities.Permission;
import com.dev.backend.entities.Person;
import com.dev.backend.entities.PersonPermission;
import com.dev.backend.repositories.PermissionRepository;
import com.dev.backend.repositories.PersonPermissionRepository;
import com.dev.backend.services.contracts.PersonPermissionService;

@Service
public class PersonPermissionServiceImpl implements PersonPermissionService {

    private final PersonPermissionRepository repository;
    private final PermissionRepository permissionRepo;

    public PersonPermissionServiceImpl(PersonPermissionRepository repository, PermissionRepository permissionRepo) {
        this.repository = repository;
        this.permissionRepo = permissionRepo;
    }

    @Override
    public void create(Person entity) {
        List<Permission> permission = permissionRepo.getByName("Client");
        if(!permission.isEmpty()){
            PersonPermission personPermission = new PersonPermission();
            personPermission.setPerson(entity);
            personPermission.setPermission(permission.get(0));
            personPermission.setInsertionDate(new Date());
            repository.saveAndFlush(personPermission);
        }    
    }
}
