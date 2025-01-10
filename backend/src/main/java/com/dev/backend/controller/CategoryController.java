package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.Category;
import com.dev.backend.services.contracts.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService service;
    
    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAll();
        if(categories.size() == 0){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        Category entity = service.getById(id);
        if(entity == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entity);
    }
    @PostMapping("/")
    public ResponseEntity<Category> create(@RequestBody Category entity) {
        if(entity == null){
            return ResponseEntity.badRequest().build();
        }
        Category result = service.create(entity);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody Category entity) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        Category result = service.update(entity);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(entity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id ){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        Category entity = service.getById(id);
        if(entity == null){
            return ResponseEntity.notFound().build();
        } 
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
    
    
}
