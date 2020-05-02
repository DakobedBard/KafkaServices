package org.mddarr.orders.event;

import org.mddarr.orders.Constants;
import org.mddarr.orders.UatAbstractTest;
import org.mddarr.orders.event.dto.Event1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.mddarr.orders.service.OrderAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageProducerTest extends UatAbstractTest {

    @Autowired
    private OrderAvroProducer messageProducer;

    @Test
    public void should_send_event1() {

    }


}