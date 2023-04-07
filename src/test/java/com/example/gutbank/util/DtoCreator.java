package com.example.gutbank.util;

import com.example.gutbank.dto.ManagerDto;
import com.example.gutbank.dto.ProductDto;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ManagerStatus;
import com.example.gutbank.entity.enums.ProductStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DtoCreator {
    public static ManagerDto getManagerDTO() {
        return new ManagerDto(
                "1",
                "Arnold",
                "Schwarzenegger",
                ManagerStatus.ACTIVE,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())
                );
    }

    public static ProductDto getProductDto() {
        return new ProductDto(
                "1",
                "Debit",
                ProductStatus.ACTIVE,
                Currencies.EUR,
                "8",
                "1000000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                getManagerDTO()
                );
    }
}