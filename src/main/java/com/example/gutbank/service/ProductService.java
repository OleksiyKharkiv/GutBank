package com.example.gutbank.service;

import com.example.gutbank.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getFindAllChangedProducts();
//    ProductDto getFindAllChangedProducts();
}