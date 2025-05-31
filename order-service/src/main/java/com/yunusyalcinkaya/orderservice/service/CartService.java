package com.yunusyalcinkaya.orderservice.service;

import com.yunusyalcinkaya.orderservice.dto.cart.BaseCartInfo;
import com.yunusyalcinkaya.orderservice.dto.cart.request.AddItemToCartRequest;
import com.yunusyalcinkaya.orderservice.dto.cart.response.AddItemToCartResponse;

public interface CartService {

    BaseCartInfo getByCustomerNumber(String customerNumber);
    AddItemToCartResponse addItemToCart(AddItemToCartRequest request);
    BaseCartInfo clearCart(String customerNumber);
}
