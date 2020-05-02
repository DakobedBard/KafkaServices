package org.mddarr.inventory.mock;

import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroSerializer;

import java.util.Map;

public class CustoProductAvroSerializer extends KafkaAvroSerializer {
    public CustoProductAvroSerializer() {
        super();
        super.schemaRegistry = new MockSchemaRegistryClient();
    }

    public CustoProductAvroSerializer(SchemaRegistryClient client) {
        super(new MockSchemaRegistryClient());
    }

    public CustoProductAvroSerializer(SchemaRegistryClient client, Map<String, ?> props) {
        super(new MockSchemaRegistryClient(), props);
    }
}
