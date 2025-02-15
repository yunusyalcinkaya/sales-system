package com.yunusyalcinkaya.catalogservice.service.impl;

import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.enums.Category;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Spy
    private ModelMapper modelMapper;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void getByCode_when_repositoryReturnObject_then_returnProductInformation() {
        // given
        String productCode = "LAP-12345";
        Product product = new Product("Laptop", productCode, "HP", "1234", Category.LAPTOP, BigDecimal.valueOf(29999.99));

        when(productRepository.findByCode(productCode)).thenReturn(product);

        // when
        ProductInformation actual = productService.getByCode(productCode);

        // then
        assertAll(() -> assertEquals("Laptop", actual.getName()),
                () -> assertEquals(productCode, actual.getCode()),
                () -> assertEquals(BigDecimal.valueOf(29999.99), actual.getPrice())
        );
    }

    @Test
    void getByCode_when_repositoryReturnNull_then_returnNull() {
        // given
        String productCode = "LAP-12345";

        when(productRepository.findByCode(productCode)).thenReturn(null);

        // when
        ProductInformation actual = productService.getByCode(productCode);

        // then
        assertNull(actual);
    }
}