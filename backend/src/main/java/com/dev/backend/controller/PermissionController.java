package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.Permission;
import com.dev.backend.entities.Person;
import com.dev.backend.services.contracts.PermissionService;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    private final PermissionService service;
    
    @Autowired
    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Permission>> getAll(){
        List<Permission> permissions = service.getAll();
        if(permissions.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permissions);
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<List<Person>> getAllPersonByPermissionId(@PathVariable("id") Long permissionId){
        List<Person> persons = service.getAllPersonByPermissionId(permissionId);
        if(persons.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }
    @PostMapping("/")
    public ResponseEntity<Permission> create(@RequestBody Permission permission){
        if(permission.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Permission result = service.create(permission);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Permission> update(@PathVariable("id") Long id, @RequestBody Permission entity){
        if(id.equals(null) || entity.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Permission result = service.update(entity);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
