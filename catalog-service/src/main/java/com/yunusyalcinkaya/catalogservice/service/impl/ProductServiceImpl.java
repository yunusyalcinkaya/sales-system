package com.yunusyalcinkaya.catalogservice.service.impl;

import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public ProductInformation getByCode(String code) {
        Product product = repository.findByCode(code);
        if (Objects.isNull(product))
            return null;
        return modelMapper.map(product, ProductInformation.class);
    }
}
