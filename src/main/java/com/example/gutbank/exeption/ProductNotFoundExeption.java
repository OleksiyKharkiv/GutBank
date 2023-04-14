package com.example.gutbank.exeption;

public class ProductNotFoundExeption extends RuntimeException{
    public ProductNotFoundExeption(String message){super(message);
    }
}