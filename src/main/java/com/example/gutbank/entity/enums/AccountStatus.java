package com.example.gutbank.entity.enums;

public enum AccountStatus {
    ACTIVE(1),
    PENDING(2),
    BLOCKING(3),
    REMOVED(4);
    private int value;

    AccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}