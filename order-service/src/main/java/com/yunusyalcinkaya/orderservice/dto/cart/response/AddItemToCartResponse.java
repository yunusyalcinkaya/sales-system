package com.yunusyalcinkaya.orderservice.dto.cart.response;

import com.yunusyalcinkaya.orderservice.dto.cart.BaseCartInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AddItemToCartResponse extends BaseCartInfo {
}
