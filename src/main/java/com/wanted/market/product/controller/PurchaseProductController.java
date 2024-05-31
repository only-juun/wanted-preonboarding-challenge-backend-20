package com.wanted.market.product.controller;

import com.wanted.market.common.BaseResponse;
import com.wanted.market.product.controller.response.PurchaseProductResponse;
import com.wanted.market.product.service.PurchaseProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PurchaseProductController {

    private final PurchaseProductService service;

    @PostMapping("/products/{productId}")
    public ResponseEntity<BaseResponse<PurchaseProductResponse>> purchaseProduct(
            @PathVariable("productId") final Long productId
    ) {
        PurchaseProductResponse response = service.purchase(productId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResponse.ok(response));
    }

}
