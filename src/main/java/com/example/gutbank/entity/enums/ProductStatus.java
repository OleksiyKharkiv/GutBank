package com.example.gutbank.entity.enums;

public enum ProductStatus {
    ACTIVE(0),
    PENDING(1),
    REMOVED(2);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}