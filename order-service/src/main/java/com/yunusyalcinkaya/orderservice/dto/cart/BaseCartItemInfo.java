package com.yunusyalcinkaya.orderservice.dto.cart;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BaseCartItemInfo {

    private String productCode;
    private short quantity;
    private BigDecimal price;
    private UUID cartId;
}
