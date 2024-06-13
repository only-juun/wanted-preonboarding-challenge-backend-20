package com.wanted.market.product.service;

import com.wanted.market.IntegrationTestSupport;
import com.wanted.market.product.controller.response.PurchaseProductResponse;
import com.wanted.market.product.domain.Product;
import com.wanted.market.product.domain.ProductStatus;
import com.wanted.market.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class PurchaseProductServiceTest extends IntegrationTestSupport {

    @Autowired
    private PurchaseProductService purchaseProductService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품을_구매한다() {
        // Given
        Product product = Product.builder()
                .name("Purchase Product")
                .price(1000L)
                .build();
        Product savedProduct = productRepository.save(product);

        // When
        PurchaseProductResponse response = purchaseProductService.purchase(savedProduct.getId());

        // Then
        List<Product> products = productRepository.findAll();
        assertThat(response.getId()).isEqualTo(savedProduct.getId());

        assertThat(products).hasSize(1)
                .extracting("name", "price", "status")
                .containsExactlyInAnyOrder(
                        tuple( "Purchase Product", 1000L, ProductStatus.RESERVED)
                );
    }

}