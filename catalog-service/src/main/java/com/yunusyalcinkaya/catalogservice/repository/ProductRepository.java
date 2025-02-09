package com.yunusyalcinkaya.catalogservice.repository;

import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByCode(String code);
    List<Product> findAllByCategory(Category category);

    @Query("select product from Product product where product.brand = :brand and (product.model is null or product.model = :model)")
    List<Product> findAllByBrandAndModel(String brand, String model);
}
