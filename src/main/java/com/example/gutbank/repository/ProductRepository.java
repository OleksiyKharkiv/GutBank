package com.example.gutbank.repository;

import com.example.gutbank.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("from Product t where t.updatedAt > t.createdAt")
    List<Product> findAllChangedProducts();
}