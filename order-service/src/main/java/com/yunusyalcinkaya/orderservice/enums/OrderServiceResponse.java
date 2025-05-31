package com.yunusyalcinkaya.orderservice.enums;

import com.yunusyalcinkaya.commonutils.util.ServiceResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderServiceResponse implements ServiceResponse {

    CART_NOT_FOUND("100", "Cart not found."),
    CART_ITEM_LIST_EMPTY("101", "Cart item list is empty.");

    private final String code;
    private final String message;
}
