package org.mddarr.inventory.api;


import org.mddarr.inventory.bean.ProductDTO;
import org.mddarr.inventory.port.ProductApiInterface;
import org.mddarr.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/")
public class ProductApi implements ProductApiInterface {

    @Autowired
    private ProductService productService;

    @Override
    public void addProduct(@RequestParam("name") String name, @RequestParam("brand") String brand, @RequestParam("price") Long price  ) {
        ProductDTO productDTO = new ProductDTO(name, brand, price,10l);
        productService.addProduct(productDTO);
    }

    @Override
    public void deleteProduct(String id) {productService.deleteProduct(id); }


}
