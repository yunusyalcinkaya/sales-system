package com.yunusyalcinkaya.orderservice.dto.cart.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddItemToCartRequest {

    @NotBlank(message = "productCode can not be blank")
    private String productCode;
    @Min(value = 1, message = "quantity must be positive")
    private short quantity;
    @NotBlank(message = "customerNumber can not be blank")
    private String customerNumber;
}
