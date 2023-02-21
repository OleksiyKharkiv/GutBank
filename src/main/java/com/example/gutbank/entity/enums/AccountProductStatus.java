package com.example.gutbank.entity.enums;

import java.awt.*;

public enum AccountProductStatus {
    ACTIVE(1),
    PENDING(2),
    BLOCKED(3),
    REMOVED(4);
    private int value;

    private AccountProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
