package com.example.gutbank.util;

import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.Manager;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ManagerStatus;
import com.example.gutbank.entity.enums.ProductStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DtoCreator {
    public static Manager getManagerDTO() {
        return new Manager(
                1,
                "Arnold",
                "Schwarzenegger",
                ManagerStatus.ACTIVE,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())
        );
    }

    public static List<ProductDto> getProductDtoList() {
        ProductDto productDto1 = new ProductDto("1", "Debit", ProductStatus.ACTIVE, Currencies.EUR, BigDecimal.valueOf(8), "1000000", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), getManagerDTO());
        ProductDto productDto2 = new ProductDto("2", "Credit", ProductStatus.ACTIVE, Currencies.EUR, BigDecimal.valueOf(12), "100000", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), getManagerDTO());
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto1);
        productDtoList.add(productDto2);
        return productDtoList;
    }
}