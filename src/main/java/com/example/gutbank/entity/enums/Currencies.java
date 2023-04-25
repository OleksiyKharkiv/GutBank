package com.example.gutbank.entity.enums;

public enum Currencies {
    EUR(0),
    USD(1),
    UAH(2),
    RUR(3);
    private final int value;

    Currencies(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}