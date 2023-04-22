package com.example.gutbank.service;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getFindAllChangedProducts();

    List<ProductDto> findAll();

    ProductDto findById(int Id);

    Product save(Product product);

    void deleteById(int Id);
    }