package com.example.gutbank.entity.enums;

public enum AccountType {
    CREDIT(1),
    DEPOSIT(2),
    UNIT(3);
    private int value;

    private AccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
