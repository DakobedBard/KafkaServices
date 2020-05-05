package org.mddarr.productservice.controller;

import org.mddarr.products.Product;
import org.mddarr.productservice.entity.ProductEntity;
import org.mddarr.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/idx")
    @CrossOrigin
    public Optional<ProductEntity> getProduct(@RequestParam(value="id") String id) {
        return productService.getProduct(id);
    }
}

