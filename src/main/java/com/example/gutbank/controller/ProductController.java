package com.example.gutbank.controller;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.exeption.ProductNotFoundExeption;
import com.example.gutbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all-changed")
    public List<ProductDto> productDtoList() {

        return productService.getFindAllChangedProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return new ProductDto(String.valueOf(product.getId()), product.getName(), product.getStatus(), product.getCurrency(),
                    String.valueOf(product.getInterestRate()), String.valueOf(product.getLimit()), product.getCreatedAt(),
                    product.getUpdatedAt(), product.getManager());
        } else {
            throw new ProductNotFoundExeption("Product not found with id " + id);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.findAll().stream()
                .map(product -> new ProductDto(String.valueOf(product.getId()), product.getName(), product.getStatus(), product.getCurrency(),
                        String.valueOf(product.getInterestRate()), String.valueOf(product.getLimit()), product.getCreatedAt(),
                        product.getUpdatedAt(), product.getManager()))
                .collect(Collectors.toList());
    }
}