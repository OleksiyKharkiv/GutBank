package com.example.gutbank.entity.enums;

public enum TransactionType {
    NEW(1),
    PENDING(2),
    APPROVED(3);
private int value;
    TransactionType(int value){this.value = value;}

    public int getValue(){
        return value;
    }

}
