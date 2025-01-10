package com.dev.backend.services.contracts;

import java.util.List;

import com.dev.backend.entities.Product;

public interface ProductService {
    public List<Product> getAllProduct();
    public List<Product> getAllByBrandId(Long id);
    public Product getById(Long id);
    public Product create(Product entity);
    public Product update(Product entity);
    public void delete(Long id);
}
