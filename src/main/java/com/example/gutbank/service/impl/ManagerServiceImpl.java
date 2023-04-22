package com.example.gutbank.service.impl;

import com.example.gutbank.dto.ManagerDto;
import com.example.gutbank.entity.Manager;
import com.example.gutbank.exception.ManagerNotFoundException;
import com.example.gutbank.mapper.ManagerMapper;
import com.example.gutbank.repository.ManagerRepository;
import com.example.gutbank.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;
    @Override
    public List<ManagerDto> findAll() {
        return managerMapper.toDtoList((List<Manager>) managerRepository.findAll());
    }
    @Override
    public ManagerDto findById(int id) {
        return managerMapper.toDto(managerRepository.findById(id).orElseThrow(() -> new ManagerNotFoundException(String.valueOf(id))));
    }
    @Override
    public Manager save(Manager manager){
        return managerRepository.save(manager);
    }
    @Override
    public void deleteById(int id){
        managerRepository.deleteById(id);
    }
}
