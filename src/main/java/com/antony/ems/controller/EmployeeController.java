package com.antony.ems.controller;

import com.antony.ems.dto.EmployeeDTO;
import com.antony.ems.service.EmployeeService;
import com.antony.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO newEmployee = employeeService.addEmployee(employeeDTO);

        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);

    }


}
