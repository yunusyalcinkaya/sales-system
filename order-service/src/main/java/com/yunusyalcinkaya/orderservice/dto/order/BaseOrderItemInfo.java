package com.yunusyalcinkaya.orderservice.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseOrderItemInfo {

    private String productCode;
    private short quantity;
    private BigDecimal price;
} 