package com.yunusyalcinkaya.catalogservice.dto;

import com.yunusyalcinkaya.catalogservice.enums.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInformation {

    private String name;
    private String code;
    private Category category;
    private String brand;
    private String model;
    private BigDecimal price;
}
