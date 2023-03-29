package com.example.gutbank.controller;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all-changed")
    public List<ProductDto>productDtoList(){

        return productService.getFindAllChangedProducts();
    }
}