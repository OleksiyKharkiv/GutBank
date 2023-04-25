package com.example.gutbank.entity.enums;

public enum AccountStatus {
    ACTIVE(0),
    PENDING(1),
    BLOCKING(2),
    REMOVED(3);
    private final int value;

    AccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}