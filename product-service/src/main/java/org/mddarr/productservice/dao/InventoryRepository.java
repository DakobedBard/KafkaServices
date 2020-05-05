package org.mddarr.productservice.dao;


import org.mddarr.productservice.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<ProductEntity, String> {

}
