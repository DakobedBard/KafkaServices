package org.mddarr.inventory.dao;

import org.mddarr.users.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<ProductEntity, String> {

}
