package cqrs.command.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Orders", schema = "cqrs-write-schema")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private int quantity;

}
