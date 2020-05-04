package org.mddarr.users.api;


import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.mddarr.users.entity.ProductEntity;
import org.mddarr.users.services.ProductService;
import org.mddarr.users.services.processors.InventoryProcessor;
import org.mddarr.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products/")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @Autowired
    private InteractiveQueryService interactiveQueryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/list")
    public List<ProductEntity> getProducts() {
        return productService.findAll();
    }


    @RequestMapping("/idx")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<ProductEntity> getProduct(@RequestParam(value="id") String id) {
        final ReadOnlyKeyValueStore<String, Product> productStore =
                interactiveQueryService.getQueryableStore(InventoryProcessor.ALL_PRODUCTS, QueryableStoreTypes.<String, Product>keyValueStore());
        return productService.getProduct(id);
//        final Product product = productStore.get(id);
//        if (product == null) {
//            throw new IllegalArgumentException("hi");
//        }
//        return new ProductBean(product.getBrand(), product.getName()) ;
    }


//    @Override
//    public String addProduct(@RequestParam("name") String name, @RequestParam("brand") String brand, @RequestParam("price") Double price, @RequestParam("quantity") Long quantity) {
//        ProductDTO productDTO = new ProductDTO(name, brand, price,quantity);
//        String id = productService.addProduct(productDTO);
//        return id;
//    }


    public void deleteProduct(String id) {productService.deleteProduct(id); }


}
