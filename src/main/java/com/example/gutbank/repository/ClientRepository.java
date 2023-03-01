package com.example.gutbank.repository;

import java.util.List;

import com.example.gutbank.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>, CrudRepository<Client, Long> {

    List<Client> findByLastName(@Param("last_name") String lastName);

}