package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.contracts.ProductImagesService;
import com.dev.backend.entities.ProductImages;

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
@RequestMapping("/api/productimage")
public class ProductImagesController {

    private final ProductImagesService service;
    
    @Autowired
    public ProductImagesController(ProductImagesService service) {
        this.service = service;
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductImages>> getAllByProductId(@PathVariable Long id) {
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        List<ProductImages> products = service.getAllByProductId(id);
        if(products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductImages> getById(@PathVariable Long id) {
        if(id.equals(id)){
            return ResponseEntity.badRequest().build();
        }
        ProductImages entity = service.getById(id);
        if(entity.equals(null)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/")
    public ResponseEntity<ProductImages> create(@RequestParam("idProduct") Long idProduct, @RequestParam("file") MultipartFile file) {
        if(idProduct.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        ProductImages result = service.create(idProduct, file);
        
        return ResponseEntity.ok(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProductImages> update(@PathVariable Long id, @RequestBody ProductImages entity) {
        if(id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        if(entity.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        ProductImages result = service.update(entity);
        
        
        return ResponseEntity.ok(result);
    }
    
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ProductImages image = service.getById(id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
