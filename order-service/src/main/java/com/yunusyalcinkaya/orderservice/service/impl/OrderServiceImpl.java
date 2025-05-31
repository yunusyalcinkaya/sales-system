package com.yunusyalcinkaya.orderservice.service.impl;

import com.yunusyalcinkaya.commonutils.util.NullSafeUtil;
import com.yunusyalcinkaya.orderservice.dto.cart.BaseCartInfo;
import com.yunusyalcinkaya.orderservice.dto.order.BaseOrderItemInfo;
import com.yunusyalcinkaya.orderservice.dto.order.request.CreateOrderRequest;
import com.yunusyalcinkaya.orderservice.dto.order.response.CreateOrderResponse;
import com.yunusyalcinkaya.orderservice.entity.Order;
import com.yunusyalcinkaya.orderservice.entity.OrderItem;
import com.yunusyalcinkaya.orderservice.enums.OrderServiceResponse;
import com.yunusyalcinkaya.orderservice.enums.OrderStatus;
import com.yunusyalcinkaya.orderservice.repository.OrderRepository;
import com.yunusyalcinkaya.orderservice.service.CartService;
import com.yunusyalcinkaya.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartService cartService;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public CreateOrderResponse createOrderFromCart(CreateOrderRequest request) {
        BaseCartInfo cart = cartService.getByCustomerNumber(request.getCustomerNumber());
        NullSafeUtil.checkIfNull(cart, OrderServiceResponse.CART_NOT_FOUND);
        NullSafeUtil.checkIfEmpty(cart.getCartItemList(), OrderServiceResponse.CART_ITEM_LIST_EMPTY);

        Order order = new Order();
        order.setCustomerNumber(request.getCustomerNumber());
        order.setAddressId(request.getAddressId());
        order.setStatus(OrderStatus.CREATED);
        order.setTotalPrice(cart.getTotalPrice());

        List<OrderItem> orderItems = cart.getCartItemList().stream()
                .map(cartItem -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductCode(cartItem.getProductCode());
                    orderItem.setQuantity(cartItem.getQuantity());
                    orderItem.setPrice(cartItem.getPrice());
                    orderItem.setOrder(order);
                    return orderItem;
                })
                .collect(Collectors.toList());
        
        order.setOrderItemList(orderItems);

        Order savedOrder = orderRepository.save(order);
        cartService.clearCart(request.getCustomerNumber());
        
        List<BaseOrderItemInfo> orderItemDTOs = savedOrder.getOrderItemList().stream()
                .map(item -> modelMapper.map(item, BaseOrderItemInfo.class))
                .collect(Collectors.toList());
        
        return CreateOrderResponse.builder()
                .id(savedOrder.getId())
                .customerNumber(savedOrder.getCustomerNumber())
                .addressId(savedOrder.getAddressId())
                .orderDate(savedOrder.getCreateTime())
                .status(savedOrder.getStatus())
                .totalPrice(savedOrder.getTotalPrice())
                .orderItems(orderItemDTOs)
                .build();
    }
} 