package com.example.gutbank.controller;

import com.example.gutbank.dto.ManagerDto;
import com.example.gutbank.entity.Manager;
import com.example.gutbank.exception.ManagerNotFoundException;
import com.example.gutbank.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/managers")
@Api(value = "Manager Controller", tags = {"Manager"})
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get manager by ID", notes = "Returns a single manager with a given ID")
    public ManagerDto getManagerbyId(@PathVariable int id) {
        ManagerDto managerDto = managerService.findById(id);
        if (managerDto != null) {
            return managerDto;
        } else {
            throw new ManagerNotFoundException("Manager with ID = " + id + "not found");
        }
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all managers", notes = "Returns a list of all managers")
    public List<ManagerDto> getAllManagers() {
        return managerService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Save manager", notes = "Save changed manager")

    public ResponseEntity<Manager> saveManager(@RequestBody Manager manager) {
        Manager saveManager = managerService.save(manager);
        return new ResponseEntity<>(saveManager, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete manager", notes = "Delete manager by ID")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        managerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}