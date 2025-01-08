package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.contracts.ProductService;
import com.dev.backend.entities.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService service;
    
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = service.getAllProduct();
        if(products.isEmpty()){
            throw new RuntimeException("No products found!");
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<List<Product>> getAllByBrandId(@PathVariable Long id) {
        List<Product> products = service.getAllByBrandId(id);
        if(products.isEmpty()){
            throw new RuntimeException("No products found!");
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        if(id.equals(null)){
            throw new IllegalArgumentException("Id must not be null");
        }
        Product entity = service.getById(id);
        return ResponseEntity.ok(entity);
    }
    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product entity) {
        if(entity.equals(null)){
            throw new IllegalArgumentException("Entity must not be null!");
        }
        Product result = service.create(entity);

        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product entity) {
        if(id.equals(null) || entity.equals(null)){
            throw new IllegalArgumentException("Id and entity must not be null!");
        }
        Product result = service.update(entity);
        
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(id.equals(null)){
            throw new IllegalArgumentException("Id must not be null");
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
