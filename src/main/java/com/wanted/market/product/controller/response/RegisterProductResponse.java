package com.wanted.market.product.controller.response;

import com.wanted.market.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterProductResponse {
    private final Long id;

    @Builder
    private RegisterProductResponse(Long id) {
        this.id = id;
    }

    public static RegisterProductResponse of(Product product) {
        return RegisterProductResponse.builder()
                .id(product.getId())
                .build();
    }
}
