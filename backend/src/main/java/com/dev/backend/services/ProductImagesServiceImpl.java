package com.dev.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.contracts.ProductImagesService;
import com.dev.backend.entities.Product;
import com.dev.backend.entities.ProductImages;
import com.dev.backend.repositories.ProductImagesRepository;
import com.dev.backend.repositories.ProductRepository;

@Service
public class ProductImagesServiceImpl implements ProductImagesService {

    private final String PATH_IMAGENS = "c:/ImagesBackEnd/";
    
    private final ProductImagesRepository repository;

    private final ProductRepository productRepository;

    
    @Autowired
    public ProductImagesServiceImpl(ProductImagesRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    

    @Override
    public List<ProductImages> getAllByProductId(Long productId) {
        return repository.getAllByProductId(productId);
    }

    @Override
    public ProductImages getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ProductImages create(Long id, MultipartFile file) {
        Product product = productRepository.findById(id).get();
        ProductImages image = new ProductImages();

        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String fileName = String.valueOf(product.getId()) + file.getOriginalFilename();
                Path path = Paths.get(PATH_IMAGENS + fileName);
                Files.write(path, bytes);

                product.setName(fileName);
                product.setAtualizationDate(new Date());
            }
        } catch(IOException e){
            e.printStackTrace();;
        }

        image.setInsertionDate(new Date());
        image.setProduct(product);

        productRepository.saveAndFlush(product);
        return repository.saveAndFlush(image); 
    }

    @Override
    public ProductImages update(ProductImages entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        ProductImages image = getById(id);
        if(!image.equals(null)){
            repository.delete(image);
        }
    }
    
}
