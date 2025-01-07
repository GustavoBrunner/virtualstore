package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.contracts.CityService;
import com.dev.backend.entities.City;
import com.dev.backend.services.CityServiceImpl;

import java.sql.Date;
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
@RequestMapping("api/city")
public class CityController {
    private final CityServiceImpl service;
    
    @Autowired
    public CityController(CityServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = service.getAll();
        if(cities.size() == 0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        City city = service.getById(id);
        if(city == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(city);
    }
    @PostMapping("/")
    public ResponseEntity<City> create(@RequestBody City entity) {
        City result = service.create(entity);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }

        
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City entity) {
        City result = service.getById(id);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        City entity = service.getById(id);
        if(entity == null){
            return ResponseEntity.badRequest().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();

    }
    
    
}
