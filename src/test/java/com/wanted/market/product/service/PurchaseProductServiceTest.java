package com.wanted.market.product.service;

import com.wanted.market.product.controller.response.PurchaseProductResponse;
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
class PurchaseProductServiceTest {

    @Autowired
    private PurchaseProductService purchaseProductService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품을_구매한다() {
        // Given
        Product product = Product.builder()
                .name("Test Product")
                .price(1000L)
                .build();
        Product savedProduct = productRepository.save(product);

        // When
        PurchaseProductResponse response = purchaseProductService.purchase(savedProduct.getId());

        // Then
        assertThat(response.getId()).isEqualTo(savedProduct.getId());

        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(1)
                .extracting("name", "price", "status")
                .containsExactlyInAnyOrder(
                        tuple( "Test Product", 1000L, ProductStatus.RESERVED)
                );
    }

}