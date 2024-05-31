package com.wanted.market.product.service;

import com.wanted.market.product.controller.request.RegisterProductCommand;
import com.wanted.market.product.controller.response.RegisterProductResponse;
import com.wanted.market.product.domain.Product;
import com.wanted.market.product.domain.ProductStatus;
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
        Product product = Product.builder()
                .name("Test Product1")
                .price(1000L)
                .build();
        productRepository.save(product);

        RegisterProductCommand command = RegisterProductCommand.builder()
                .name("Test Product2")
                .price(2000L)
                .build();

        // When
        RegisterProductResponse response = registerProductService.register(command);

        // Then
        assertThat(response.getId()).isEqualTo(2L);

        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(2)
                .extracting("name", "price", "status")
                .containsExactlyInAnyOrder(
                        tuple( "Test Product1", 1000L, ProductStatus.SALE),
                        tuple( "Test Product2", 2000L, ProductStatus.SALE)
                );
     }


}