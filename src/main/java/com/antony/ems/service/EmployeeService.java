package com.antony.ems.service;

import com.antony.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employee);

    EmployeeDTO getEmployee(int id);

    EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);

    void deleteEmployee(int id);

    List<EmployeeDTO> getAllEmployees();

}
