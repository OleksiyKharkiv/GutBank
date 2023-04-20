package com.example.gutbank.service;
//package com.example.gutbank.service.impl;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.mapper.ProductMapper;
import com.example.gutbank.repository.ProductRepository;
import com.example.gutbank.entity.Product;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;
import com.example.gutbank.service.impl.ProductServiceImpl;
import com.example.gutbank.util.EntityCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;

    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository, productMapper);
    }

    @Test
    void getFindAllChangedProducts() {
        // create some sample products
        List<Product> productList = EntityCreator.getProductList();

        // mock the repository method to return the sample products
        when(productRepository.findAllChangedProducts()).thenReturn(productList);

        // mock the mapper method to return the DTOs for the sample products
        ProductDto productDto1 = new ProductDto("1", "Product 1", ProductStatus.ACTIVE, Currencies.USD, BigDecimal.valueOf(2.5), "1000", Timestamp.valueOf(LocalDateTime.now().minusHours(1)), Timestamp.valueOf(LocalDateTime.now()), null);
        ProductDto productDto2 = new ProductDto("2", "Product 2", ProductStatus.ACTIVE, Currencies.EUR, BigDecimal.valueOf(3.5), "5000", Timestamp.valueOf(LocalDateTime.now().minusDays(1)), Timestamp.valueOf(LocalDateTime.now()), null);
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto1);
        productDtoList.add(productDto2);
        when(productMapper.toDtoList(productList)).thenReturn(productDtoList);

        // call the service method
        List<ProductDto> result = productService.getFindAllChangedProducts();

        // assert that the result is the same as the mocked DTOs
        assertEquals(productDtoList, result);
    }
}