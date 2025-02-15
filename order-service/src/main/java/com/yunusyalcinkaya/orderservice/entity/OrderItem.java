package com.yunusyalcinkaya.orderservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String productCode;

    @Positive(message = "Quantity must be positive")
    private short quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public OrderItem(String productCode, short quantity, Order order, Cart cart) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.order = order;
        this.cart = cart;
    }
}
