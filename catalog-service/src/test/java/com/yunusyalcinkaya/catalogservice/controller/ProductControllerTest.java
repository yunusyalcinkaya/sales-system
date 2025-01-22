package com.yunusyalcinkaya.catalogservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunusyalcinkaya.catalogservice.dto.CustomResponseEntity;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProductService productService;

    @Test
    void getByCode_when_givenProductCode_then_returnProductInfotmation() throws Exception {
        // given
        String code = "LAP-12345";
        ProductInformation productInformation = new ProductInformation();
        productInformation.setCode(code);
        productInformation.setName("Laptop");
        productInformation.setPrice(BigDecimal.valueOf(29000));

        CustomResponseEntity<ProductInformation> apiResponse = new CustomResponseEntity<>(productInformation);

        when(productService.getByCode(code)).thenReturn(productInformation);

        // when - then
        mockMvc.perform(get("/api/v1/product/LAP-12345"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.code").value(code))
                .andExpect(jsonPath("$.content.name").value("Laptop"))
                .andExpect(jsonPath("$.content.price").value(BigDecimal.valueOf(29000)));
    }
}