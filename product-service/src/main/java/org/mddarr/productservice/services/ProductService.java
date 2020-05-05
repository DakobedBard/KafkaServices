package org.mddarr.productservice.services;


import org.mddarr.productservice.dao.InventoryRepository;
import org.mddarr.productservice.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    InventoryRepository productRepository;

    public List<ProductEntity> findAll() {
        List<ProductEntity> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Optional<ProductEntity> getProduct(String id){
        return productRepository.findById(id);
    }

    public void deleteProduct(String id){productRepository.deleteById(id);}
}
