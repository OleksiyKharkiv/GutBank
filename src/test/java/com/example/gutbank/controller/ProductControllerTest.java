package com.example.gutbank.controller;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.service.ProductService;
import com.example.gutbank.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
@DisplayName("Test class for ProductController")
public class ProductControllerTest {
    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void productDtoList() throws Exception {
        final List<ProductDto> productDtoList = DtoCreator.getProductDtoList();
        when(productService.getFindAllChangedProducts()).thenReturn(productDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/all-changed"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(productDtoList.get(0).getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(productDtoList.get(0).getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status", is(productDtoList.get(0).getStatus().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].currency", is(productDtoList.get(0).getCurrency().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].interestRate").value(productDtoList.get(0).getInterestRate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].limit").value(productDtoList.get(0).getLimit()));
    }
}