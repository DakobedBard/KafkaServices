package org.mddarr.productservice.controller;

import org.mddarr.productservice.entity.ProductEntity;
import org.mddarr.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    @CrossOrigin
    public List<ProductEntity> getProducts() {
        return productService.findAll();
    }
}

