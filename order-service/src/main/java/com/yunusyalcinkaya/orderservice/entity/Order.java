package com.yunusyalcinkaya.orderservice.entity;

import com.yunusyalcinkaya.commonutils.entity.BaseEntity;
import com.yunusyalcinkaya.orderservice.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(length = 10, nullable = false)
    private String customerNumber;

    @Column(length = 50, nullable = false)
    private String addressId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;
    
    @Positive(message = "Price must be positive")
    @Column(precision = 8, scale = 2)
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;

    public Order(String customerNumber, String addressId, OrderStatus status, BigDecimal totalPrice, List<OrderItem> orderItemList) {
        this.customerNumber = customerNumber;
        this.addressId = addressId;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderItemList = orderItemList;
    }
}
