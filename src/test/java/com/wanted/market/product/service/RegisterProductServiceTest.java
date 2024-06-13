package com.wanted.market.product.service;

import com.wanted.market.IntegrationTestSupport;
import com.wanted.market.product.controller.request.RegisterProductCommand;
import com.wanted.market.product.domain.Product;
import com.wanted.market.product.domain.ProductStatus;
import com.wanted.market.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RegisterProductServiceTest extends IntegrationTestSupport {

    @Autowired
    private RegisterProductService registerProductService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 신규_상품을_등록한다() {
        // Given
        Product product = Product.builder()
                .name("Test Product")
                .price(1000L)
                .build();
        productRepository.save(product);

        RegisterProductCommand command = RegisterProductCommand.builder()
                .name("Register Product1")
                .price(2000L)
                .build();

        // When
        registerProductService.register(command);

        // Then
        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(2)
                .extracting("name", "price", "status")
                .containsExactlyInAnyOrder(
                        tuple( "Test Product", 1000L, ProductStatus.SALE),
                        tuple( "Register Product1", 2000L, ProductStatus.SALE)
                );

     }


}