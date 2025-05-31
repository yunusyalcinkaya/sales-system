package com.yunusyalcinkaya.orderservice.repository;

import com.yunusyalcinkaya.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByCustomerNumber(String customerNumber);
}
