package com.yunusyalcinkaya.customerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String district;

    @Column(length = 50, nullable = false)
    private String street;

    @Positive(message = "Building number must be possitive")
    private short buildingNumber;

    @Positive(message = "Door number must be possitive")
    private short doorNumber;

    @Positive(message = "Postal code must be possitive")
    private int postalCode;
}
