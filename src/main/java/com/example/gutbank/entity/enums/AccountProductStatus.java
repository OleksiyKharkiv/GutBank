package com.example.gutbank.entity.enums;

public enum AccountProductStatus {
    ACTIVE(0),
    PENDING(1),
    BLOCKED(2),
    REMOVED(3);
    private final int value;

    AccountProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}