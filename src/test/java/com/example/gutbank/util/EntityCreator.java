package com.example.gutbank.util;

import com.example.gutbank.entity.Manager;
import com.example.gutbank.entity.Product;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class EntityCreator {
    public static Product getProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("Debit");
        product.setStatus(ProductStatus.ACTIVE);
        product.setCurrency(Currencies.EUR);
        product.setInterestRate(BigDecimal.valueOf(8));
        product.setLimit(1000000);
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
//        product.setManager();
        return product;
    }
}
