package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.dto.PersonClientRequestDto;
import com.dev.backend.entities.Person;
import com.dev.backend.services.contracts.PersonClientService;

@RestController
@RequestMapping("api/client")
public class PersonClientController {
    
    private final PersonClientService service;

    @Autowired
    public PersonClientController(PersonClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody PersonClientRequestDto dto){
        if(dto.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        Person result = service.create(dto);

        return ResponseEntity.ok(result);
    }
    
    
}
