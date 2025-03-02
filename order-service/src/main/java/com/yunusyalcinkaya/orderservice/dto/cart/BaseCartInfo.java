package com.yunusyalcinkaya.orderservice.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCartInfo {

    private String customerNumber;
    private List<BaseCartItemInfo> cartItemList;
}
