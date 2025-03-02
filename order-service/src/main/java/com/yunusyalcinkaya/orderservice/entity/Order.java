package com.yunusyalcinkaya.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 10, nullable = false)
    private String customerNumber;

    @Column(length = 50, nullable = false)
    private String addressId;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;

    public Order(String customerNumber, String addressId, LocalDateTime orderDate, List<OrderItem> orderItemList) {
        this.customerNumber = customerNumber;
        this.addressId = addressId;
        this.orderDate = orderDate;
        this.orderItemList = orderItemList;
    }
}
