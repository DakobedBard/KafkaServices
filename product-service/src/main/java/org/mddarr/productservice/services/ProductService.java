package org.mddarr.productservice.services;


import org.mddarr.productservice.dao.ProductRepository;
import org.mddarr.productservice.entity.ProductDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDocument> findAll() {
        List<ProductDocument> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Optional<ProductDocument> getProduct(String id){
        return productRepository.findById(id);
    }

    public void deleteProduct(String id){productRepository.deleteById(id);}
}
