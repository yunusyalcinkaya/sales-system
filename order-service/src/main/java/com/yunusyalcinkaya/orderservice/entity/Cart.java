package com.yunusyalcinkaya.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 10, nullable = false)
    private String customerNumber;

    @OneToMany(mappedBy = "cart")
    private List<OrderItem> orderItemList;

    public Cart(String customerNumber, List<OrderItem> orderItemList) {
        this.customerNumber = customerNumber;
        this.orderItemList = orderItemList;
    }
}
