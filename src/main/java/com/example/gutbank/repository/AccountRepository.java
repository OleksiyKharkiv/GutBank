package com.example.gutbank.repository;

import com.example.gutbank.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AccountRepository extends CrudRepository<Account, Integer> {
    List<Account> findById(String id);

    Account findByIdAndName(String id, String name);
}