package com.yunusyalcinkaya.catalogservice.service.impl;

import com.yunusyalcinkaya.catalogservice.constant.RedisConstant;
import com.yunusyalcinkaya.catalogservice.dto.AddProductRequest;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.enums.Category;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(cacheNames = {RedisConstant.ALL_PRODUCTS})
    public List<ProductInformation> getAll() {
        List<Product> products = repository.findAll();
        if (CollectionUtils.isEmpty(products))
            return null;

        return products.stream()
                .map(product -> modelMapper.map(product, ProductInformation.class))
                .toList();
    }

    @Override
    public ProductInformation getByCode(String code) {
        Product product = repository.findByCode(code);
        if (Objects.isNull(product))
            return null;

        return modelMapper.map(product, ProductInformation.class);
    }

    @Override
    public List<ProductInformation> getByCategory(Category category) {
        List<Product> products = repository.findAllByCategory(category);
        if (CollectionUtils.isEmpty(products))
            return null;

        return products.stream()
                .map(product -> modelMapper.map(product, ProductInformation.class))
                .toList();
    }

    @Override
    public List<ProductInformation> getByBrandAndModel(String brand, String model) {
        List<Product> products = repository.findAllByBrandAndModel(brand, model);
        if (CollectionUtils.isEmpty(products))
            return null;

        return products.stream()
                .map(product -> modelMapper.map(product, ProductInformation.class))
                .toList();
    }

    @Override
    @CacheEvict(cacheNames = {RedisConstant.ALL_PRODUCTS})
    public void add(AddProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        repository.save(product);
    }
}
