package com.dev.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Brand;
import com.dev.backend.repositories.BrandRepository;
import com.dev.backend.services.contracts.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;

    @Autowired
    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Brand create(Brand entity) {
        entity.setInsertionDate(new Date());
        return repository.save(entity);
    }

    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    public Brand getById(Long id) {
        Optional<Brand> entity = repository.findById(id);
        return entity.get();
    }

    @Override
    public Brand update(Brand entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        Brand brand = getById(id);
        repository.delete(brand);
    }
    
}
