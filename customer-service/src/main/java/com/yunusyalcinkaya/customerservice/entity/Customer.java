package com.yunusyalcinkaya.customerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 10, nullable = false, unique = true)
    private String customerNumber;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_addresses",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Address> addressList;
}
