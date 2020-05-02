package org.mddarr.inventory;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mddarr.inventory.api.ProductApi;
import org.mddarr.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Category(IntegrationTest.class)
@EmbeddedKafka()
public class ProductControllerIntegrationTests {
    @Autowired
    private ProductApi productApi;

    @Test

    public void createProduct(){
        String id = UUID.randomUUID().toString();
        Product product = new Product(id,"Nike", "Jordan 24", 134.2, 120l);


    }
}
