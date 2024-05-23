package cqrs.command.repository;

import cqrs.command.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCommandRepository extends JpaRepository<Order, Long> {
}