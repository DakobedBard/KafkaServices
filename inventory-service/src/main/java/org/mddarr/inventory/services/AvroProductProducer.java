package org.mddarr.inventory.services;

import org.mddarr.inventory.entity.ProductEntity;
import org.mddarr.products.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AvroProductProducer {
    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplateEvent1;

    private static final Logger logger = LoggerFactory.getLogger(AvroProductProducer.class);

    public void sendProduct(ProductEntity product) {
        logger.info("Send product  {}", product);
        Product prod = new Product(product.getId(), product.getBrand(), product.getName(), product.getPrice(), product.getQuantity());
        kafkaTemplateEvent1.send("product-feed",product.getId(), prod);
    }



}
