package com.example.gutbank.controller;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Product;
import com.example.gutbank.exception.ProductNotFoundException;
import com.example.gutbank.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Api(value = "Product Controller", tags = {"Product"})
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all-changed")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all changed product", notes = "Returns all product which have been changed(updated)")
    public List<ProductDto> productDtoList() {

        return productService.getFindAllChangedProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get product by ID", notes = "Returns a single product with a given ID")

    public ProductDto getProductById(@PathVariable int id) {
        ProductDto product = productService.findById(id);
        if (product != null) {
            return product;
//            return new ProductDto(String.valueOf(product.getId()), product.getName(), product.getStatus(), product.getCurrency(),
//                    product.getInterestRate(), String.valueOf(product.getLimit()), product.getCreatedAt(),
//                    product.getUpdatedAt(), product.getManager());
        } else {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all products", notes = "Returns a list of all products")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }
}