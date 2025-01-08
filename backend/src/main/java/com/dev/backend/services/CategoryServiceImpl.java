package com.dev.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.contracts.CategoryService;
import com.dev.backend.entities.Category;
import com.dev.backend.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    
    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category category) {
        category.setInsertionDate(new Date());
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        category.setAtualizationDate(new Date());
        return repository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Long id) {
        Optional<Category> result = repository.findById(id);
        return result.get();
    }

    @Override
    public void delete(Long id) {
        Optional<Category> entity = repository.findById(id);
        repository.delete(entity.get());
    }
    
}
