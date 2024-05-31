package com.wanted.market.product.domain;

import com.wanted.market.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Builder
    private Product(String name, long price) {
        this.name = name;
        this.price = price;
        this.status = ProductStatus.SALE;
    }

    public static Product of(String name, long price) {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }

    public void purchase() {
        this.status = ProductStatus.RESERVED;
    }

}
