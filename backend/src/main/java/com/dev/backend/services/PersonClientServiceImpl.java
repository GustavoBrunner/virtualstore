package com.dev.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.PersonClientRequestDto;
import com.dev.backend.entities.Person;
import com.dev.backend.repositories.PermissionRepository;
import com.dev.backend.repositories.PersonClientRepository;
import com.dev.backend.repositories.PersonRepository;
import com.dev.backend.services.contracts.PersonClientService;
import com.dev.backend.services.contracts.PersonPermissionService;


@Service
public class PersonClientServiceImpl implements PersonClientService {

    private final PersonClientRepository repository;
    
    private final PersonPermissionService personPermissionService;

    

    @Autowired
    public PersonClientServiceImpl(PersonClientRepository repository, PersonPermissionService personPermissionService) {
        this.repository = repository;
        this.personPermissionService = personPermissionService;
    }




    @Override
    public Person create(PersonClientRequestDto dto) {
        Person entity = dto.converter(dto); 
        entity.setInsertionDate(new Date());

        Person newPerson = repository.save(entity);
        personPermissionService.create(newPerson);

        return newPerson;
        
    }



    
    
}
