package com.yunusyalcinkaya.catalogservice.service;

import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.enums.Category;

import java.util.List;

public interface ProductService {

    ProductInformation getByCode(String code);
    List<ProductInformation> getByCategory(Category category);
}
