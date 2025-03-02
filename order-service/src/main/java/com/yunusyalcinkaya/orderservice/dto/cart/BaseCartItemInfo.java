package com.yunusyalcinkaya.orderservice.dto.cart;

import lombok.Data;

import java.util.UUID;

@Data
public class BaseCartItemInfo {

    private String productCode;
    private String quantity;
    private UUID cartId;
}
