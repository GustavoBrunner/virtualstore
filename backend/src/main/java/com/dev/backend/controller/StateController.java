package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.State;
import com.dev.backend.services.StateServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/state")
public class StateController {
    
    private final StateServiceImpl service;

    @Autowired
    public StateController(StateServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<State> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public State getById(@PathVariable("id") Long param) {
        return service.getById(param);
    }
    
    @PutMapping("/{id}")
    public State update(@PathVariable("id") Long id, @RequestBody State entity) {
        //TODO: process PUT request
        State state = getById(id);
        
        if(state != null){
            service.update(entity);
        }
        
        return entity;
    }

    @PostMapping("/")
    public State create(@RequestBody State entity) {
        //TODO: process POST request
        service.create(entity);
        
        return entity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
