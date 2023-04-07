package com.example.gutbank.mapper;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test class for ProductMapper")
public class ProductMapperTest {
    private final ProductMapper productMapper = new ProductMapperImpl();

    @Test
    @DisplayName("When we have correct entity then return correct ProductDto")
    void testProductToProductDto() {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = productMapper.toDto(product);
        assertAll(
                () -> assertEquals(String.valueOf(product.getId()), productDto.getId()),
                () -> assertEquals(product.getName(), productDto.getName()),
                () -> assertEquals(product.getStatus(), productDto.getStatus()),
                () -> assertEquals(product.getCurrency(), productDto.getCurrency())
        );
    }
}