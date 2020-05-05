package org.mddarr.inventory;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mddarr.users.api.ProductApi;

import org.mddarr.inventory.mock.CustomProductAvroDeserializer;
import org.mddarr.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Category(IntegrationTest.class)
@EmbeddedKafka()
public class ProductControllerIntegrationTests {
//    @Autowired
//    private ProductApi productApi;
//    @Autowired
//    private KafkaProperties kafkaProperties;
//    @Autowired
//    private EmbeddedKafkaBroker kafkaEmbedded;
//
//
//    protected Consumer<String, Product> productConsumer;

    @Before
    public void setUp() {
//        Map<String, Object> senderProps = kafkaProperties.buildProducerProperties();
//
//        //consumers used in test code needs to be created like this in code because otherwise it won't work
//        Map<String, Object> configs = new HashMap<>(KafkaTestUtils.consumerProps("in-test-consumer", "false", kafkaEmbedded));
//        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringDeserializer.class);
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomProductAvroDeserializer.class);
//        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        configs.put("schema.registry.url", "not-used");
//        kafkaProperties.buildConsumerProperties();
//
//        productConsumer = new DefaultKafkaConsumerFactory<String, Product>(configs).createConsumer("in-test-consumer", "10");
//        kafkaProperties.buildConsumerProperties();
//
//        productConsumer.subscribe(Lists.newArrayList("product-feed"));
    }

    @Test
    public void createProduct(){


    }

    @After
    public void reset() {
//        productConsumer.close();
    }

}
