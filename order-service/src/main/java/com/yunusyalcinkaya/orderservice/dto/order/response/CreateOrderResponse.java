package com.yunusyalcinkaya.orderservice.dto.order.response;

import com.yunusyalcinkaya.orderservice.dto.order.BaseOrderItemInfo;
import com.yunusyalcinkaya.orderservice.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {

    private UUID id;
    private String customerNumber;
    private String addressId;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private List<BaseOrderItemInfo> orderItems;
} 