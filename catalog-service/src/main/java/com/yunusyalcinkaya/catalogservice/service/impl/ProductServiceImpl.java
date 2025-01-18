package com.yunusyalcinkaya.catalogservice.service.impl;

import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductInformation getByCode(String code) {
        Product product = repository.findByCode(code);
        return modelMapper.map(product, ProductInformation.class);
    }
}
