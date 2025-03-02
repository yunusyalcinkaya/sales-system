package com.yunusyalcinkaya.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartItem> cartItemList = new ArrayList<>();

    public Cart(String customerNumber, List<CartItem> cartItemList) {
        this.customerNumber = customerNumber;
        this.cartItemList = cartItemList;
    }
}
