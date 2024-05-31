package com.wanted.market.product.service;

import com.wanted.market.product.controller.request.RegisterProductCommand;
import com.wanted.market.product.controller.response.RegisterProductResponse;
import com.wanted.market.product.domain.Product;
import com.wanted.market.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterProductService {

    private final ProductRepository productRepository;

    public RegisterProductResponse register(RegisterProductCommand command) {
        Product product = command.toProduct();

        Product savedProduct = productRepository.save(product);

        return RegisterProductResponse.of(savedProduct);
    }
}
