package com.example.gutbank.mapper;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    List<ProductDto> toDtoList(List<Product> products);
}