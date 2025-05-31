package com.yunusyalcinkaya.catalogservice.controller;

import com.yunusyalcinkaya.catalogservice.dto.AddProductRequest;
import com.yunusyalcinkaya.catalogservice.dto.ProductInformation;
import com.yunusyalcinkaya.catalogservice.enums.Category;
import com.yunusyalcinkaya.catalogservice.service.ProductService;
import com.yunusyalcinkaya.commonutils.dto.CustomResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
@Tag(name = "Product API", description = "CRUD operations and query endpoints for products")
public class ProductController {

    private final ProductService productService;

    @Operation(
        summary = "Get product by code",
        description = "Returns product details for the given product code.",
        parameters = @Parameter(
            name = "code",
            description = "Unique code of the product",
            required = true,
            example = "LAP-1234"
        )
    )
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ProductInformation.class)))
    @GetMapping("/{code}")
    public CustomResponseEntity<ProductInformation> getByCode(@PathVariable String code) {
        return new CustomResponseEntity<>(productService.getByCode(code));
    }

    @Operation(
        summary = "Get all products",
        description = "Lists all products in the system."
    )
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ProductInformation.class)))
    @GetMapping
    public CustomResponseEntity<List<ProductInformation>> getAll() {
        return new CustomResponseEntity<>(productService.getAll());
    }

    @Operation(
        summary = "Get products by category",
        description = "Lists products belonging to the specified category.",
        parameters = @Parameter(
            name = "category",
            description = "Product category",
            required = true,
            example = "LAPTOP"
        )
    )
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ProductInformation.class)))
    @GetMapping("/category/{category}")
    public CustomResponseEntity<List<ProductInformation>> getByCategory(@PathVariable Category category) {
        return new CustomResponseEntity<>(productService.getByCategory(category));
    }

    @Operation(
        summary = "Get products by brand and model",
        description = "Lists products for the specified brand and model.",
        parameters = {
            @Parameter(name = "brand", description = "Product brand", required = true, example = "HP"),
            @Parameter(name = "model", description = "Product model", required = true, example = "EliteBook")
        }
    )
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ProductInformation.class)))
    @GetMapping("/brand/{brand}/model/{model}")
    public CustomResponseEntity<List<ProductInformation>> getByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return new CustomResponseEntity<>(productService.getByBrandAndModel(brand, model));
    }

    @Operation(
        summary = "Add new product",
        description = "Adds a new product to the system.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Product information to be added",
            required = true,
            content = @Content(schema = @Schema(implementation = AddProductRequest.class))
        )
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping
    public void add(@RequestBody AddProductRequest request) {
        productService.add(request);
    }

    @Operation(
        summary = "Update product",
        description = "Updates the product with the specified ID.",
        parameters = @Parameter(
            name = "id",
            description = "ID of the product to be updated",
            required = true,
            example = "b1a7e7e2-8c2e-4e2a-9b1a-2e7e2c2e7e2c"
        ),
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Product information to be updated",
            required = true,
            content = @Content(schema = @Schema(implementation = AddProductRequest.class))
        )
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody AddProductRequest request) {
        productService.update(id, request);
    }

    @Operation(
        summary = "Delete product",
        description = "Deletes the product with the specified ID.",
        parameters = @Parameter(
            name = "id",
            description = "ID of the product to be deleted",
            required = true,
            example = "b1a7e7e2-8c2e-4e2a-9b1a-2e7e2c2e7e2c"
        )
    )
    @ApiResponse(responseCode = "200", description = "Success")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }
}
