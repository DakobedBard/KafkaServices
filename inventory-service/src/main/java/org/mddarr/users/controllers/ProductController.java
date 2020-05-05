package org.mddarr.users.controllers;

import org.mddarr.users.bean.ProductBean;
import org.mddarr.users.bean.ProductPurchaseCountBean;
import org.mddarr.users.services.processors.InventoryProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.state.HostInfo;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.mddarr.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private InteractiveQueryService interactiveQueryService;

    private final Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/product/topsellers")
    @SuppressWarnings("unchecked")
    public List<ProductPurchaseCountBean> topFive(@RequestParam(value="brand") String brand) {

        HostInfo hostInfo = interactiveQueryService.getHostInfo(InventoryProcessor.TOP_FIVE_PRODUCTS_STORE,
                InventoryProcessor.TOP_FIVE_KEY, new StringSerializer());

        if (interactiveQueryService.getCurrentHostInfo().equals(hostInfo)) {
            logger.info("Top Five products request served from same host: " + hostInfo);
            return topFiveProducts(InventoryProcessor.TOP_FIVE_KEY, InventoryProcessor.TOP_FIVE_PRODUCTS_STORE);
        }
        else {
            //find the store from the proper instance.
            logger.info("Top Five songs request served from different host: " + hostInfo);
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(
                    String.format("http://%s:%d/%s", hostInfo.host(),
                            hostInfo.port(), "charts/top-five?genre=Punk"), "punk", List.class);
        }
    }

    private List<ProductPurchaseCountBean> topFiveProducts(final String key, final String storeName) {
        final ReadOnlyKeyValueStore<String, InventoryProcessor.TopFiveProducts> topFiveStore =
                interactiveQueryService.getQueryableStore(storeName, QueryableStoreTypes.<String, InventoryProcessor.TopFiveProducts>keyValueStore());

        // Get the value from the store
        final InventoryProcessor.TopFiveProducts value = topFiveStore.get(key);
        if (value == null) {
            throw new IllegalArgumentException(String.format("Unable to find value in %s for key %s", storeName, key));
        }
        final List<ProductPurchaseCountBean> results = new ArrayList<>();
        value.forEach(productPurchaseCount -> {

            HostInfo hostInfo = interactiveQueryService.getHostInfo(InventoryProcessor.ALL_PRODUCTS,
                    productPurchaseCount.getProductId(), new StringSerializer());

            if (interactiveQueryService.getCurrentHostInfo().equals(hostInfo)) {
                logger.info("Product info request served from same host: " + hostInfo);

                final ReadOnlyKeyValueStore<String, Product> productStore =
                        interactiveQueryService.getQueryableStore(InventoryProcessor.ALL_PRODUCTS, QueryableStoreTypes.<String, Product>keyValueStore());

                final Product product = productStore.get(productPurchaseCount.getProductId());
                results.add(new ProductPurchaseCountBean(product.getBrand(),product.getName(), productPurchaseCount.getCount()));
            }
            else {
                logger.info("Product info request served from different host: " + hostInfo);
                RestTemplate restTemplate = new RestTemplate();
                ProductBean product = restTemplate.postForObject(
                        String.format("http://%s:%d/%s", hostInfo.host(),
                                hostInfo.port(), "song/idx?id=" + productPurchaseCount.getProductId()),  "id", ProductBean.class);
                results.add(new ProductPurchaseCountBean(product.getBrand(),product.getName(),productPurchaseCount.getCount()));
            }
        });
        return results;
    }

}
