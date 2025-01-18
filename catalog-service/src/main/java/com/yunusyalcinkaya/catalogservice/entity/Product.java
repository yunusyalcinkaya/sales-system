package com.yunusyalcinkaya.catalogservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false, unique = true)
    private String productCode;
    @Positive(message = "Price must be positive")
    @Column(precision = 8, scale = 2)
    private BigDecimal price;

    public Product(String name, String code, BigDecimal price) {
        this.name = name;
        this.productCode = code;
        this.price = price;
    }

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
