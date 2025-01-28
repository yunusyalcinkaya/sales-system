package com.yunusyalcinkaya.customerservice.repository;

import com.yunusyalcinkaya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface CustomerRepository extends JpaRepository<Customer, UID> {

    Customer findByCustomerNumber(String customerNumber);
}
