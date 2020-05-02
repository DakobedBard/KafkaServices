package org.mddarr.inventory.port;

import org.mddarr.inventory.entity.ProductEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.mddarr.inventory.bean.ProductDTO;

import java.util.UUID;

public interface ProductApiInterface {

    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    String addProduct(@RequestParam("name") String name, @RequestParam("brand") String brand, @RequestParam("price") Double price, @RequestParam("quantity") Long quantity);

    @RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    void deleteProduct(String id);
}

