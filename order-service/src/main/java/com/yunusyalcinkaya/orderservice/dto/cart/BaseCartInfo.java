package com.yunusyalcinkaya.orderservice.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCartInfo {

    private String customerNumber;
    private BigDecimal totalPrice;
    private List<BaseCartItemInfo> cartItemList;
}
