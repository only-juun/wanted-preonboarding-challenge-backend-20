package com.wanted.market;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.market.product.service.PurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public abstract class ControllerTestSupport {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    protected PurchaseProductService purchaseProductService;
}
