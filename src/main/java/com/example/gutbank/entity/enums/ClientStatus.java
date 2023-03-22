package com.example.gutbank.entity.enums;

public enum ClientStatus {
    ACTIVE(0),
    PENDING(1),
    REMOVE(2),
    BLOCKING(3);
    private int value;

    ClientStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}