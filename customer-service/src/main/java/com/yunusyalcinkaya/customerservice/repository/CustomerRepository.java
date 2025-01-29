package com.yunusyalcinkaya.customerservice.repository;

import com.yunusyalcinkaya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findByCustomerNumber(String customerNumber);
}
