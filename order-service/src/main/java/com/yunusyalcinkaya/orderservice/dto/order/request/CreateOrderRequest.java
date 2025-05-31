package com.yunusyalcinkaya.orderservice.dto.order.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank(message = "Customer number is required")
    @Size(min = 1, max = 10, message = "Customer number must be between 1 and 10 characters")
    private String customerNumber;
    
    @NotBlank(message = "Address ID is required")
    @Size(min = 1, max = 50, message = "Address ID must be between 1 and 50 characters")
    private String addressId;
} 