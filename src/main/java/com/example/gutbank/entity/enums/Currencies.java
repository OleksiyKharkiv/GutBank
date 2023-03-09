package com.example.gutbank.entity.enums;

import com.sun.jdi.PrimitiveValue;

public enum Currencies {
    EUR(1),
    USD(2),
    UAH(3),
    RUR(4);
    private int value;

    private Currencies(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}