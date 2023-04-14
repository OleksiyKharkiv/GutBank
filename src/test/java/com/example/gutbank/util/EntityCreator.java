package com.example.gutbank.util;

import com.example.gutbank.entity.Product;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EntityCreator {
    public static List<Product> getProductList() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Debit");
        product1.setStatus(ProductStatus.ACTIVE);
        product1.setCurrency(Currencies.EUR);
        product1.setInterestRate(BigDecimal.valueOf(8));
        product1.setLimit(1000000);
        product1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product1.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        product1.setManager(null);
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Credit");
        product2.setStatus(ProductStatus.ACTIVE);
        product2.setCurrency(Currencies.EUR);
        product2.setInterestRate(BigDecimal.valueOf(12));
        product2.setLimit(100000);
        product2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product2.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        product2.setManager(null);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        return productList;
    }
}