package com.antony.ems.controller;

import com.antony.ems.dto.EmployeeDTO;
import com.antony.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO newEmployee = employeeService.addEmployee(employeeDTO);

        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")

    public ResponseEntity<EmployeeDTO> fetchEmployee(@PathVariable("id") int id){

        EmployeeDTO employeeDTO = employeeService.getEmployee(id);

        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")

    public String deleteEmployee(@PathVariable("id") int id){

        employeeService.deleteEmployee(id);

        return "Employee deleted Successfully";

    }

    @GetMapping("/all")

    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeList(){

        List<EmployeeDTO> allEmployee = employeeService.getAllEmployees();

        return new ResponseEntity<>(allEmployee,HttpStatus.OK);

    }




}
