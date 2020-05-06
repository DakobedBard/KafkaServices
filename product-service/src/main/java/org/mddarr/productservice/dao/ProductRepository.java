package org.mddarr.productservice.dao;

import org.mddarr.productservice.entity.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDocument, String> {
}
