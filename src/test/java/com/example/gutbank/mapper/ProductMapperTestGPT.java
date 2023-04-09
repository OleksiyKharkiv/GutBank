package com.example.gutbank.mapper;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;
import com.example.gutbank.util.EntityCreator;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTestGPT {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void shouldMapProductToProductDto() {
        // when
        ProductDto productDto = productMapper.toDto(EntityCreator.getProductList().get(1));

        // then
        assertEquals("1", productDto.getId());
        assertEquals("Test product", productDto.getName());
        assertEquals(ProductStatus.ACTIVE, productDto.getStatus());
        assertEquals(Currencies.EUR, productDto.getCurrency());
        assertEquals("0.05", productDto.getInterestRate());
        assertEquals("1000", productDto.getLimit());
        assertEquals(Timestamp.valueOf("2023-04-05 12:34:56"), productDto.getCreatedAt());
        assertEquals(Timestamp.valueOf("2023-04-05 12:34:56"), productDto.getUpdatedAt());
        assertEquals(2, productDto.getManager().getId());
    }

    @Test
    void shouldMapProductListToProductDtoList() {
        // given

        List<Product> products = EntityCreator.getProductList();

        // when
        List<ProductDto> productDtoList = productMapper.toDtoList(products);
    }
}