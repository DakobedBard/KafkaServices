package org.mddarr.inventory.mock;

import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.avro.Schema;
import org.mddarr.orders.event.dto.Order;

/**
 * This code is not thread safe and should not be used in production environment
 */
public class CustomProductAvroDeserializer extends KafkaAvroDeserializer {
    @Override
    public Object deserialize(String topic, byte[] bytes) {
        if (topic.equals("orders")) {
            this.schemaRegistry = getMockClient(Order.SCHEMA$);
        }

        return super.deserialize(topic, bytes);
    }

    private static SchemaRegistryClient getMockClient(final Schema schema$) {
        return new MockSchemaRegistryClient() {
            @Override
            public synchronized Schema getById(int id) {
                return schema$;
            }
        };
    }
}
