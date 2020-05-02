package org.mddarr.inventory.dao;

import org.mddarr.inventory.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<ProductEntity, String> {

}
