package com.wanted.market.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {

    private final T data;

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(data);
    }

}
