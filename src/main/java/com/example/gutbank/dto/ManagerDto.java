package com.example.gutbank.dto;

import com.example.gutbank.entity.enums.ManagerStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.sql.Timestamp;
@Value
public class ManagerDto {
    String id;
    String firstName;
    String lastName;
    ManagerStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp updatedAt;
}