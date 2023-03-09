package com.example.gutbank.repository;

import com.example.gutbank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findById(String id);

    Account findAllByName(String name);
}