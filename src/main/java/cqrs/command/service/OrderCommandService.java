package cqrs.command.service;

import cqrs.command.event.service.OrderEventProducerService;
import cqrs.command.model.Order;
import cqrs.command.repository.OrderCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderCommandService {

    private OrderCommandRepository orderCommandRepository;

    private OrderEventProducerService orderEventProducerService;

    public Order createOrder(Order order) {
        Order savedOrder = orderCommandRepository.save(order);
        orderEventProducerService.createOrderEvent(savedOrder);
        return orderCommandRepository.save(order);
    }

}