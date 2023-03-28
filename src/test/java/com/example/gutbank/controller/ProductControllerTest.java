package com.example.gutbank.controller;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.service.ProductService;
import com.example.gutbank.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
@DisplayName("Test class for ProductController")
public class ProductControllerTest {
    @MockBean
    private ProductService productService;
    @Test
    void findAllChangedProducts() {
        final List<ProductDto> productDtoList = new ArrayList<>();
        final ProductDto productDto = DtoCreator.findAllChangedProducts();
        when(productService.getFindAllChangedProducts()).thenReturn(productDtoList);

    }
}
