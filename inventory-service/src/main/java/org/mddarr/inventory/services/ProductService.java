package org.mddarr.inventory.services;

import org.mddarr.inventory.bean.ProductDTO;
import org.mddarr.inventory.dao.InventoryRepository;
import org.mddarr.inventory.entity.ProductEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    InventoryRepository postgresRepository;

    @Autowired
    AvroProductProducer avroProductProducer;

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    public void addProduct(ProductDTO productDTO){
        UUID uuid =  UUID.randomUUID();
        ProductEntity product = new ProductEntity(uuid.toString(),productDTO.getName(),productDTO.getBrand(),productDTO.getPrice(), productDTO.getQuantity());
        postgresRepository.save(product);
        avroProductProducer.sendProduct(product);
    }

    public Optional<ProductEntity> getProduct(String id){
        return postgresRepository.findById(id);
    }
    public void deleteProduct(String id){postgresRepository.deleteById(id);}


}
