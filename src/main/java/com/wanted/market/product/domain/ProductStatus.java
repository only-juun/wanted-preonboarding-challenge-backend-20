package com.wanted.market.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatus {
    SALE("판매 중"),
    RESERVED("예약 중"),
    SOLD("판매 완료");

    private final String message;
}
