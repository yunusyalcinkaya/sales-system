package com.yunusyalcinkaya.orderservice.entity;

import com.yunusyalcinkaya.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "carts")
public class Cart extends BaseEntity {

    @Column(length = 10, nullable = false)
    private String customerNumber;
    
    @Positive(message = "Price must be positive")
    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartItem> cartItemList = new ArrayList<>();

    public Cart(String customerNumber, BigDecimal totalPrice, List<CartItem> cartItemList) {
        this.customerNumber = customerNumber;
        this.totalPrice = totalPrice;
        this.cartItemList = cartItemList;
    }
}
