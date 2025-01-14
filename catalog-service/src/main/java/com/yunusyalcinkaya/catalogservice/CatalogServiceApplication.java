package com.yunusyalcinkaya.catalogservice;

import com.yunusyalcinkaya.catalogservice.entity.Product;
import com.yunusyalcinkaya.catalogservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class CatalogServiceApplication {

    private final ProductRepository productRepository;

    public CatalogServiceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Product product = productRepository.findByCode("LAP-12345");

            if (Objects.isNull(product)) {
                productRepository.saveAll(List.of(
                        new Product("Laptop", "LAP-12345", BigDecimal.valueOf(29999.99)),
                        new Product("Smartphone", "SMT-98765", BigDecimal.valueOf(14999.99)),
                        new Product("Headphones", "HP-56789", BigDecimal.valueOf(8999.99)),
                        new Product("Wireless Mouse", "WM-11122", BigDecimal.valueOf(2999.50)),
                        new Product("Gaming Keyboard", "GK-22334", BigDecimal.valueOf(4500)),
                        new Product("4K Monitor", "MON-33445", BigDecimal.valueOf(14899.49))
                ));
            }
        };
    }
}
