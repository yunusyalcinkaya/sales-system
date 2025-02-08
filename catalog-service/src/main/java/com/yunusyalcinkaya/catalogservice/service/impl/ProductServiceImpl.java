package com.yunusyalcinkaya.catalogservice.service.impl;

import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.enums.Category;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
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

    @Override
    public List<ProductInformation> getByCategory(Category category) {
        // todo: add redis cache, unit test, endpoint
        List<Product> products = repository.findAllByCategory(category);
        if (CollectionUtils.isEmpty(products))
            return null;

        return products.stream()
                .map(product -> modelMapper.map(product, ProductInformation.class))
                .toList();
    }
}
