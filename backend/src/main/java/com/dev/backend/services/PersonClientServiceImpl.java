package com.dev.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.PersonClientRequestDto;
import com.dev.backend.entities.Email;
import com.dev.backend.entities.Person;
import com.dev.backend.repositories.PersonClientRepository;
import com.dev.backend.services.contracts.EmailService;
import com.dev.backend.services.contracts.PersonClientService;
import com.dev.backend.services.contracts.PersonPermissionService;
import com.dev.backend.util.PersonClientConverter;

@Service
public class PersonClientServiceImpl implements PersonClientService {

    private final PersonClientRepository repository;

    private final PersonPermissionService personPermissionService;

    private final EmailService emailService;

   

    @Autowired
    public PersonClientServiceImpl(PersonClientRepository repository,
            PersonPermissionService personPermissionService, EmailService emailService) {
        this.repository = repository;
        this.personPermissionService = personPermissionService;
        this.emailService = emailService;
    }

    @Override
    public Person create(PersonClientRequestDto dto) {
        Person entity = PersonClientConverter.converter(dto); 
        entity.setInsertionDate(new Date());

        Person newPerson = repository.save(entity);
        personPermissionService.create(newPerson);
        if(newPerson.equals(null)){
            emailService.sendEmail(new Email(newPerson.getEmail(), 
                        "Operation Fail", "Fail to registry your data to the system"));
        }
        emailService.sendEmail(new Email(newPerson.getEmail(), 
                        "Operation Success", "Success to registry your data to the system"));
        return newPerson;
        
    }

}
