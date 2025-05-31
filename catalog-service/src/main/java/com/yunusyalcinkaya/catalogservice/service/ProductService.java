package com.yunusyalcinkaya.catalogservice.service;

import com.yunusyalcinkaya.catalogservice.dto.AddProductRequest;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.enums.Category;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductInformation> getAll();
    ProductInformation getByCode(String code);
    List<ProductInformation> getByCategory(Category category);
    List<ProductInformation> getByBrandAndModel(String brand, String model);
    void add(AddProductRequest request);
    void update(UUID id, AddProductRequest request);
    void delete(UUID id);

}
