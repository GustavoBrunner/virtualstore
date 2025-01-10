package com.dev.backend.services.contracts;

import java.util.List;

import com.dev.backend.entities.Brand;

public interface BrandService {
    public Brand create(Brand entity);
    public List<Brand> getAll(); 
    public Brand getById(Long id);
    public Brand update(Brand entity);
    public void delete(Long id);
}
