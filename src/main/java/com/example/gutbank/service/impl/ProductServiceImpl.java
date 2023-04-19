package com.example.gutbank.service.impl;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.exception.ProductNotFoundException;
import com.example.gutbank.mapper.ProductMapper;
import com.example.gutbank.repository.ProductRepository;
import com.example.gutbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getFindAllChangedProducts() {
        List<Product> products = productRepository.findAllChangedProducts();
        if (products == null || products.isEmpty()) {
            throw new ProductNotFoundException("No products found.");
        }
        return productMapper.toDtoList(productRepository.findAllChangedProducts());
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toDtoList((List<Product>) productRepository.findAll());
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}