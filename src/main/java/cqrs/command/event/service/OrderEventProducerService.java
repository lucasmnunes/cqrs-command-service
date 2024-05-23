package cqrs.command.event.service;

import cqrs.command.event.model.OrderCreatedEvent;
import cqrs.command.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderEventProducerService {

    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    private static final String KAFKA_TOPIC_NAME = "order-events";

    public void createOrderEvent(Order savedOrder) {
        OrderCreatedEvent orderCreatedEvent = OrderCreatedEvent.builder()
                .id(savedOrder.getId())
                .product(savedOrder.getProduct())
                .quantity(savedOrder.getQuantity())
                .build();

        kafkaTemplate.send(KAFKA_TOPIC_NAME, orderCreatedEvent);
    }

}
