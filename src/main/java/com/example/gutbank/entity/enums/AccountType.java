package com.example.gutbank.entity.enums;

public enum AccountType {
    CREDIT(0),
    DEPOSIT(1),
    UNIT(2);
    private int value;

    AccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}