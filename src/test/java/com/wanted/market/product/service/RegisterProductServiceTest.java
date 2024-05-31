package com.wanted.market.product.service;

import com.wanted.market.product.controller.request.RegisterProductCommand;
import com.wanted.market.product.controller.response.RegisterProductResponse;
import com.wanted.market.product.domain.Product;
import com.wanted.market.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@Transactional
class RegisterProductServiceTest {

    @Autowired
    private RegisterProductService registerProductService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 신규_상품을_등록한다() {
        // Given
        RegisterProductCommand command = RegisterProductCommand.builder()
                .name("Test Product")
                .price(1000L)
                .build();

        // When
        RegisterProductResponse response = registerProductService.register(command);

        // Then
        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(1)
                .extracting("name", "price")
                .containsExactlyInAnyOrder(
                        tuple( "Test Product", 1000L)
                );
     }


}