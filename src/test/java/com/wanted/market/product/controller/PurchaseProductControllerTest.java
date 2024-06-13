package com.wanted.market.product.controller;

import com.wanted.market.ControllerTestSupport;
import com.wanted.market.product.controller.response.PurchaseProductResponse;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PurchaseProductController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PurchaseProductControllerTest extends ControllerTestSupport {

    @Test
    void 상품을_구매할_수_있다() throws Exception {
        // given
        Long productId = 1L;
        PurchaseProductResponse response = PurchaseProductResponse.builder()
                .id(productId)
                .build();

        when(purchaseProductService.purchase(anyLong())).thenReturn(response);

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/products/{productId}", productId)
                        .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(productId));
    }

}