package com.yunusyalcinkaya.orderservice.dto.cart.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddItemToCartRequest {

    @NotBlank(message = "productCode can not be blank")
    private String productCode;
    @Min(value = 1, message = "quantity must be positive")
    private short quantity;
    @NotBlank(message = "customerNumber can not be blank")
    private String customerNumber;
    @NotNull(message = "price can not be null")
    @Positive(message = "price must be positive")
    private BigDecimal price;
}
