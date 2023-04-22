package com.example.gutbank.service;

import com.example.gutbank.dto.ManagerDto;
import com.example.gutbank.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<ManagerDto> findAll();

    ManagerDto findById(int id);
    Manager save(Manager manager);
    void deleteById(int id);
}