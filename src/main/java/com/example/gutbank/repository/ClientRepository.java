package com.example.gutbank.repository;

import com.example.gutbank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long>, JpaRepository<Client, Long> {

    List<Client> findByLastName(@Param("last_name") String lastName);

}