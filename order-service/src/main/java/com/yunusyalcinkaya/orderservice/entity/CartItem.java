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
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String productCode;

    @Positive(message = "Quantity must be positive")
    private short quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public CartItem(String productCode, short quantity, Cart cart) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.cart = cart;
    }
}
