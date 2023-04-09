package com.example.gutbank.mapper;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test class for ProductMapper")
public class ProductMapperTest {
    private final ProductMapper productMapper = new ProductMapperImpl();

    @Test
    @DisplayName("When we have correct entity then return correct ProductDto")
    void testProductToProductDto() {
        List<Product> product = EntityCreator.getProductList();
        ProductDto productDto = productMapper.toDto(product.get(0));
        assertAll(
                () -> assertEquals(String.valueOf(product.get(0).getId()), productDto.getId()),
                () -> assertEquals(product.get(0).getName(), productDto.getName()),
                () -> assertEquals(product.get(0).getStatus(), productDto.getStatus()),
                () -> assertEquals(product.get(0).getCurrency(), productDto.getCurrency())
        );
    }
}