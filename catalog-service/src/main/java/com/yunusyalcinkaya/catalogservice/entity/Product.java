package com.yunusyalcinkaya.catalogservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String code;

    @Positive(message = "Price must be positive")
    @Column(precision = 8, scale = 2)
    private BigDecimal price;

    public Product(String name, String code, BigDecimal price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }
}
