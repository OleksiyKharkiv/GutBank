package com.example.gutbank.entity.enums;

public enum TransactionType {
    NEW(0),
    PENDING(1),
    APPROVED(2);
    private final int value;

    TransactionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}