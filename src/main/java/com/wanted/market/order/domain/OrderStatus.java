package com.wanted.market.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    IN_PROGRESS("진행 중"),
    COMPLETED("판매 승인");

    private final String description;
}
