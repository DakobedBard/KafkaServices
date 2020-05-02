package org.mddarr.payments.services;

import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.mddarr.orders.event.dto.Order;
import org.mddarr.orders.event.dto.OrderState;
import org.mddarr.orders.event.dto.ValidatedOrder;
import org.mddarr.products.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
public class PaymentsValidationService {
    public class PaymentsProcessor {
        @Bean
        public Function<KStream<String, ValidatedOrder>,KStream<String, ValidatedOrder>> process() {
            return (validatedOrderStream)-> {

                KStream<String, ValidatedOrder> stocked = validatedOrderStream.filter((key, value) -> value.getState() == OrderState.OUT_OF_STOCK);
                KStream<String, ValidatedOrder> out_of_stock = validatedOrderStream.filter((key, value) -> value.getState() == OrderState.STOCKED);

                validatedOrderStream.foreach(new ForeachAction() {
                    @Override
                    public void apply(Object key, Object value) {
                        System.out.print("THe key value IN THE JOINED VALUE K STREAM of othe product is .. ");
                        System.out.println(key + ": " + value);
                    }
                });

                return validatedOrderStream;};
        }
    }
}