package com.example.gutbank.entity.enums;

public enum Currencies {
    EUR(1),
    USD(2),
    UAH(3),
    RUR(4);
    private int value;

    Currencies(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}