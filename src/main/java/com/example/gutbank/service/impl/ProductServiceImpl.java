package com.example.gutbank.service.impl;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.mapper.ProductMapper;
import com.example.gutbank.repository.ProductRepository;
import com.example.gutbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getFindAllChangedProducts() {
        return productMapper.toDtoList(productRepository.findAllChangedProducts());
    }
}