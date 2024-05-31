package com.wanted.market.product.controller.response;

import com.wanted.market.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PurchaseProductResponse {

    private final Long id;

    @Builder
    private PurchaseProductResponse(Long id) {
        this.id = id;
    }

    public static PurchaseProductResponse of(Product product) {
        return PurchaseProductResponse.builder()
                .id(product.getId())
                .build();
    }
}
