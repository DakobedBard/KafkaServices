package org.mddarr.users.services;

import org.mddarr.users.dao.InventoryRepository;
import org.mddarr.users.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    InventoryRepository productRepository;

    @Autowired
    AvroProductProducer avroProductProducer;

    public List<ProductEntity> findAll() {
        List<ProductEntity> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Optional<ProductEntity> getProduct(String id){
        return productRepository.findById(id);
    }


//    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
//    public String addProduct(ProductDTO productDTO){
//        UUID uuid =  UUID.randomUUID();
//        ProductEntity product = new ProductEntity(uuid.toString(),productDTO.getName(),productDTO.getBrand(),productDTO.getPrice(), productDTO.getQuantity());
//        productRepository.save(product);
//        avroProductProducer.sendProduct(product);
//        return uuid.toString();
//    }


    public void deleteProduct(String id){productRepository.deleteById(id);}



}
