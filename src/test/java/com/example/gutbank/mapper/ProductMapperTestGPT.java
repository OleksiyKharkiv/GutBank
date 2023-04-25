package com.example.gutbank.mapper;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.util.EntityCreator;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTestGPT {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void shouldMapProductToProductDto() {
        // when
        List<Product> product = EntityCreator.getProductList();
        ProductDto productDto = productMapper.toDto(EntityCreator.getProductList().get(1));

        // then
        assertEquals(String.valueOf(product.get(1).getId()), productDto.getId());
        assertEquals(product.get(1).getName(), productDto.getName());
        assertEquals(product.get(1).getStatus(), productDto.getStatus());
        assertEquals(product.get(1).getCurrency(), productDto.getCurrency());
        assertEquals(product.get(1).getInterestRate(), productDto.getInterestRate());
        assertEquals(String.valueOf(product.get(1).getLimit()), productDto.getLimit());
        assertEquals(product.get(1).getManager().getId(), productDto.getManager().getId());
    }

    @Test
    void shouldMapProductListToProductDtoList() {
        // given

        List<Product> products = EntityCreator.getProductList();

        List<ProductDto> productDtoList = productMapper.toDtoList(products);
    }
}