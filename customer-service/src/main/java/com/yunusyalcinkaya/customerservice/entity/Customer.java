package com.yunusyalcinkaya.customerservice.entity;

import com.yunusyalcinkaya.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

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
