package com.yunusyalcinkaya.orderservice.repository;

import com.yunusyalcinkaya.orderservice.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {

    void deleteAllByCartId(UUID cartId);
}
