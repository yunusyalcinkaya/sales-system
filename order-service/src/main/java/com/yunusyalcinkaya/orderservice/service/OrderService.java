package com.yunusyalcinkaya.orderservice.service;

import com.yunusyalcinkaya.orderservice.dto.order.request.CreateOrderRequest;
import com.yunusyalcinkaya.orderservice.dto.order.response.CreateOrderResponse;

public interface OrderService {

    CreateOrderResponse createOrderFromCart(CreateOrderRequest request);
} 