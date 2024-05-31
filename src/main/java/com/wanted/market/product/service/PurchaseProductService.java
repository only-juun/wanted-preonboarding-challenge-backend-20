package com.wanted.market.product.service;

import com.wanted.market.product.controller.response.PurchaseProductResponse;
import com.wanted.market.product.domain.Product;
import com.wanted.market.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PurchaseProductService {

    private final ProductRepository productRepository;

    public PurchaseProductResponse purchase(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow();

        product.purchase();

        return PurchaseProductResponse.of(product);
    }
}
