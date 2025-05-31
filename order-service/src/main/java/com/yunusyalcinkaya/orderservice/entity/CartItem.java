package com.yunusyalcinkaya.orderservice.entity;

import com.yunusyalcinkaya.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cart_items")
public class CartItem extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String productCode;

    @Positive(message = "Quantity must be positive")
    private short quantity;

    @Positive(message = "Price must be positive")
    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public CartItem(String productCode, short quantity, BigDecimal price, Cart cart) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
        this.cart = cart;
    }
}
