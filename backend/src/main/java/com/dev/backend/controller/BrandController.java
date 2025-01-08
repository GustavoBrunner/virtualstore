package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.contracts.BrandService;
import com.dev.backend.entities.Brand;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/brand")
public class BrandController {
    
    private final BrandService service;

    @Autowired
    public BrandController(BrandService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Brand>> getAll() {
        List<Brand> entities = service.getAll();
        if(entities.size() == 0){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(entities);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getById(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        Brand brand = service.getById(id);
        if(brand == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brand);
    }
    @PostMapping("/")
    public ResponseEntity<Brand> create(@RequestBody Brand entity) {
        if(entity.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Brand result = service.create(entity);
        if(result.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable String id, @RequestBody Brand entity) {
        if(id.equals(null) || entity.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Brand result = service.update(entity);
        if(result.equals(null)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Brand brand = service.getById(id);
        if(brand.equals(null)){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
    
    

}
