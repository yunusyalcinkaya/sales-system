package com.yunusyalcinkaya.catalogservice.controller;

import com.yunusyalcinkaya.catalogservice.dto.CustomResponseEntity;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Get product by code",
            description = "Retrieve product details by providing the product code.",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "The unique code of the product",
                            required = true,
                            example = "LAP-1234"
                    )
            }
    )
    @GetMapping("/{code}")
    public CustomResponseEntity<ProductInformation> getByCode(@PathVariable String code) {
        return new CustomResponseEntity<>(productService.getByCode(code));
    }
}
