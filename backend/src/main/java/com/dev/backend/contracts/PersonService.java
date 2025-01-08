package com.dev.backend.contracts;

import java.util.List;

import com.dev.backend.entities.Person;

public interface PersonService {
    
    public List<Person> getAll();
    public List<Person> getAllByCityId(Long cityId);
    public Person getById(Long id);
    public Person create(Person entity);
    public Person update(Person entity);
    public void delete(Long id);
}
