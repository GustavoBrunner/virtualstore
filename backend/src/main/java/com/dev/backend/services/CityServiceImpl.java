package com.dev.backend.services;

import java.beans.JavaBean;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.contracts.CityService;
import com.dev.backend.entities.City;
import com.dev.backend.repositories.CityRepository;

@Service
public class CityServiceImpl implements CityService{
    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City create(City city) {
        city.setInsertionDate(new Date());
        return repository.save(city);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    public City getById(Long id) {
        Optional<City> result = repository.findById(id);
        return result.get();
    }

    @Override
    public City update(City city) {
        city.setAtualizationDate(new Date());
        return repository.save(city);
    }

    @Override
    public void delete(Long id) {
        City entity = getById(id);
        repository.delete(entity);
    }
}
