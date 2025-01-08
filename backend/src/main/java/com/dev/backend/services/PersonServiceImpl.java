package com.dev.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.backend.contracts.PersonService;
import com.dev.backend.entities.Person;
import com.dev.backend.repositories.PersonRepository;
import com.dev.backend.util.CpfValidator;
import com.dev.backend.util.EmailValidator;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Person> getAllByCityId(Long cityId) {
        return repository.getAllByCityId(cityId);
    }

    @Override
    public Person getById(Long id) {
        Person person = repository.findById(id).get();
        return person;
    }

    @Override
    public Person create(Person entity) {
        try{
            EmailValidator.isValid(entity.getEmail());
             
            CpfValidator.isValid(entity.getCpf());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        
        return repository.save(entity);
    }

    @Override
    public Person update(Person entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        Person entity = repository.findById(id).get();
        repository.delete(entity);
    }
    
}
