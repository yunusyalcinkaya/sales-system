package com.yunusyalcinkaya.catalogservice.service;

import com.yunusyalcinkaya.catalogservice.dto.AddProductRequest;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.enums.Category;

import java.util.List;

public interface ProductService {

    List<ProductInformation> getAll();
    ProductInformation getByCode(String code);
    List<ProductInformation> getByCategory(Category category);
    List<ProductInformation> getByBrandAndModel(String brand, String model);
    void add(AddProductRequest request);

}
