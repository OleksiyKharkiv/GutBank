package com.example.gutbank.controller;

import com.example.gutbank.entity.Account;
import com.example.gutbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/all")
    public List<Account> allAccount() {
        return (List<Account>) accountRepository.findAll();
    }
}