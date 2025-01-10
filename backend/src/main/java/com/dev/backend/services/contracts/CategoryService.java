package com.dev.backend.services.contracts;

import java.util.List;

import com.dev.backend.entities.Category;

public interface CategoryService {
    
    public Category create(Category category);
    public Category update(Category category);
    public List<Category> getAll();
    public Category getById(Long id);
    public void delete(Long id);
}
