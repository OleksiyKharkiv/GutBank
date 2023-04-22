package com.example.gutbank.mapper;

import com.example.gutbank.dto.ManagerDto;
import com.example.gutbank.entity.Manager;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerDto toDto(Manager manager);

    List<ManagerDto> toDtoList(List<Manager> managers);
}