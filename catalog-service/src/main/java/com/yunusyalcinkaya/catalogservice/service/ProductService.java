package com.yunusyalcinkaya.catalogservice.service;

import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;

public interface ProductService {

    ProductInformation getByCode(String code);
}
