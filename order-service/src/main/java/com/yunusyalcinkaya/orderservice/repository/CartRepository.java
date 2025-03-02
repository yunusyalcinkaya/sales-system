package com.yunusyalcinkaya.orderservice.repository;

import com.yunusyalcinkaya.orderservice.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    Cart findByCustomerNumber(String customerNumber);
}
