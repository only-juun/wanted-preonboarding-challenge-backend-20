package com.wanted.market.product.controller.request;

import com.wanted.market.product.domain.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterProductCommand {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @Min(value = 1, message = "가격은 1원 이상이어야 합니다.")
    private long price;

    @Builder
    private RegisterProductCommand(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }
}
