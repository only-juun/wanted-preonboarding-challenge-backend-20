package com.wanted.market.product.controller;

import com.wanted.market.common.BaseResponse;
import com.wanted.market.product.controller.request.RegisterProductCommand;
import com.wanted.market.product.controller.response.RegisterProductResponse;
import com.wanted.market.product.service.RegisterProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterProductController {

    private final RegisterProductService service;

    @PostMapping("/products")
    public ResponseEntity<BaseResponse<RegisterProductResponse>> register(
            @Valid @RequestBody RegisterProductCommand command
    ) {
        RegisterProductResponse response = service.register(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(response));
    }

}
