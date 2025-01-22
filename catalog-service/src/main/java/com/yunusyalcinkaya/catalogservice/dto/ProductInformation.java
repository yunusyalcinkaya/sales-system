package com.yunusyalcinkaya.catalogservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInformation {

    private String name;
    private String code;
    private BigDecimal price;
}
