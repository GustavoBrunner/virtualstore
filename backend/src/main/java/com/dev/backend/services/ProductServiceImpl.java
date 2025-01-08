package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.contracts.ProductService;
import com.dev.backend.entities.Product;
import com.dev.backend.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllByBrandId(Long id) {
        return repository.getAllByBrandId(id);
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Product create(Product entity) {
        entity.setInsertionDate(new Date());
        return repository.save(entity);
    }

    @Override
    public Product update(Product entity) {
        Product product = repository.findById(entity.getId()).get();
        if(product.getAtualizationDate() != null){
            entity.setAtualizationDate(product.getAtualizationDate());
        }
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        Product product = getById(id);
        repository.delete(product);
    }
    
}
