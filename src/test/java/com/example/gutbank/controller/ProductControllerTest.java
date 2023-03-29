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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

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
        final List<ProductDto> productDtoList = new ArrayList<>();
        final ProductDto productDto = DtoCreator.getProductDto();
        when(productService.getFindAllChangedProducts()).thenReturn(productDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/all-changed"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].id").value(productDto.getId()))
                .andExpect((ResultMatcher) jsonPath("$[0].name").value(productDto.getName()))
                .andExpect((ResultMatcher) jsonPath("$[0].status", is(productDto.getStatus())))
                .andExpect((ResultMatcher) jsonPath("$[0].currency", is(productDto.getCurrency())))
                .andExpect((ResultMatcher) jsonPath("$[0].interestRate", is(productDto.getInterestRate())))
                .andExpect((ResultMatcher) jsonPath("$[0].createdAt", is(productDto.getCreatedAt())))
                .andExpect((ResultMatcher) jsonPath("$[0].updatedAt", is(productDto.getUpdatedAt())));
    }
}
