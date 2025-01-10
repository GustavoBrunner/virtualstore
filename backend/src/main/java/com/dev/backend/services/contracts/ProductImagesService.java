package com.dev.backend.services.contracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entities.ProductImages;

public interface ProductImagesService { 

    public List<ProductImages> getAllByProductId(Long productId);
    public ProductImages getById(Long id);
    public ProductImages create(Long id, MultipartFile file);
    public ProductImages update(ProductImages entity);
    public void delete(Long id);

}
