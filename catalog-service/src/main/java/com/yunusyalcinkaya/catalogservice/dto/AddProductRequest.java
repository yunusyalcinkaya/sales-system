package com.yunusyalcinkaya.catalogservice.dto;

import com.yunusyalcinkaya.catalogservice.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {

    @NotBlank(message = "name can not be blank")
    private String name;
    @NotBlank(message = "code can not be blank")
    private String code;
    private Category category;
    private String brand;
    @NotBlank(message = "model can not be blank")
    private String model;
    @NotNull(message = "price can not be null")
    private BigDecimal price;
}
