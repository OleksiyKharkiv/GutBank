package com.example.gutbank.entity.enums;

public enum ProductStatus {
    ACTIVE(1),
    PENDING(2),
    REMOVED(3);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}