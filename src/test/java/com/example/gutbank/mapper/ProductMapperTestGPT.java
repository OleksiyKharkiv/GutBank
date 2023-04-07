package com.example.gutbank.mapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Manager;
import com.example.gutbank.entity.Product;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;
import com.example.gutbank.mapper.ProductMapper;

public class ProductMapperTestGPT {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void shouldMapProductToProductDto() {
        // given
        Product product = new Product();
        product.setId(1);
        product.setName("Test product");
        product.setStatus(ProductStatus.ACTIVE);
        product.setCurrency(Currencies.EUR);
        product.setInterestRate(new BigDecimal("0.05"));
        product.setLimit(1000);
        product.setCreatedAt(Timestamp.valueOf("2023-04-05 12:34:56"));
        product.setUpdatedAt(Timestamp.valueOf("2023-04-05 12:34:56"));
        Manager manager = new Manager();
        manager.setId(2);
        product.setManager(manager);

        // when
        ProductDto productDto = productMapper.toDto(product);

        // then
        assertEquals("1", productDto.getId());
        assertEquals("Test product", productDto.getName());
        assertEquals(ProductStatus.ACTIVE, productDto.getStatus());
        assertEquals(Currencies.EUR, productDto.getCurrency());
        assertEquals("0.05", productDto.getInterestRate());
        assertEquals("1000", productDto.getLimit());
        assertEquals(Timestamp.valueOf("2023-04-05 12:34:56"), productDto.getCreatedAt());
        assertEquals(Timestamp.valueOf("2023-04-05 12:34:56"), productDto.getUpdatedAt());
//        assertEquals(2, productDto.getManager().getId());
    }

    @Test
    void shouldMapProductListToProductDtoList() {
        // given
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Test product 1");
        product1.setStatus(ProductStatus.ACTIVE);
        product1.setCurrency(Currencies.EUR);
        product1.setInterestRate(new BigDecimal("0.05"));
        product1.setLimit(1000);
        product1.setCreatedAt(Timestamp.valueOf("2023-04-05 12:34:56"));
        product1.setUpdatedAt(Timestamp.valueOf("2023-04-05 12:34:56"));
        Manager manager1 = new Manager();
        manager1.setId(2);
        product1.setManager(manager1);

        Product product2 = new Product();
        product2.setId(3);
        product2.setName("Test product 2");
        product2.setStatus(ProductStatus.REMOVED);
        product2.setCurrency(Currencies.USD);
        product2.setInterestRate(new BigDecimal("0.03"));
        product2.setLimit(500);
        product2.setCreatedAt(Timestamp.valueOf("2023-04-06 09:00:00"));
        product2.setUpdatedAt(Timestamp.valueOf("2023-04-06 09:00:00"));
        Manager manager2 = new Manager();
        manager2.setId(4);
        product2.setManager(manager2);

        List<Product> products = Arrays.asList(product1, product2);

        // when
        List<ProductDto> productDtoList = productMapper.toDtoList(products);
    }
}

