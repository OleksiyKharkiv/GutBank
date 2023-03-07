package com.example.gutbank.repository;

import com.example.gutbank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findById(String id);

    Account findAllByName(String name);
}