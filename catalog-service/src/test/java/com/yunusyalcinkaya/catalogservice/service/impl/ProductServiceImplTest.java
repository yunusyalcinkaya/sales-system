package com.yunusyalcinkaya.catalogservice.service.impl;

import com.yunusyalcinkaya.catalogservice.dto.AddProductRequest;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.enums.Category;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

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

    @Test
    void add_shouldSaveProduct() {
        // given
        AddProductRequest request = new AddProductRequest();
        request.setName("Phone");
        request.setCode("PHN-001");
        request.setBrand("Apple");
        request.setModel("iPhone 14");
        request.setCategory(Category.SMART_PHONE);
        request.setPrice(BigDecimal.valueOf(19999.99));

        // when
        productService.add(request);

        // then
        Mockito.verify(productRepository).save(Mockito.any(Product.class));
    }

    @Test
    void update_shouldUpdateProduct() {
        // given
        UUID id = UUID.randomUUID();
        Product product = new Product("OldName", "OLD-001", "OldBrand", "OldModel", Category.SMART_PHONE, BigDecimal.valueOf(1000));
        AddProductRequest request = new AddProductRequest();
        request.setName("NewName");
        request.setCode("NEW-001");
        request.setBrand("NewBrand");
        request.setModel("NewModel");
        request.setCategory(Category.LAPTOP);
        request.setPrice(BigDecimal.valueOf(2999.99));

        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));

        // when
        productService.update(id, request);

        // then
        assertEquals("NewName", product.getName());
        assertEquals("NEW-001", product.getCode());
        assertEquals("NewBrand", product.getBrand());
        assertEquals("NewModel", product.getModel());
        assertEquals(Category.LAPTOP, product.getCategory());
        assertEquals(BigDecimal.valueOf(2999.99), product.getPrice());
        Mockito.verify(productRepository).save(product);
    }

    @Test
    void delete_shouldDeleteProduct() {
        // given
        UUID id = UUID.randomUUID();

        // when
        productService.delete(id);

        // then
        Mockito.verify(productRepository).deleteById(id);
    }
}