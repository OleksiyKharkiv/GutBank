package com.example.gutbank.entity.enums;

public enum ClientStatus {
    ACTIVE(1),
    PENDING(2),
    REMOVE(3),
    BLOCKING(4);
    private int value;

    ClientStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}