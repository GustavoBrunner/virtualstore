package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.Person;
import com.dev.backend.services.contracts.PersonService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll() {
        List<Person> persons = service.getAll();
        if(persons.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }
    @GetMapping("/city/{id}")
    public ResponseEntity<List<Person>> getAllByCityId(@PathVariable Long id) {
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        List<Person> persons = service.getAllByCityId(id);
        if(persons.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Person person = service.getById(id);
        return ResponseEntity.ok(person);
    }
    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person entity) {
        if(entity.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Person result = service.create(entity);
        
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person entity) {
        if(id.equals(null) || entity.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Person result = service.update(entity);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
    
    
    
}
