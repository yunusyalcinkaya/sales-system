package com.yunusyalcinkaya.orderservice.service;

import com.yunusyalcinkaya.orderservice.dto.cart.request.AddItemToCartRequest;
import com.yunusyalcinkaya.orderservice.dto.cart.response.AddItemToCartResponse;

public interface CartService {

    AddItemToCartResponse addItemToCart(AddItemToCartRequest request);
}
