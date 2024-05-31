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
    private double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Builder
    private Product(String name, double price, ProductStatus status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public static Product of(String name, double price, ProductStatus status) {
        return Product.builder()
                .name(name)
                .price(price)
                .status(status)
                .build();
    }

}
