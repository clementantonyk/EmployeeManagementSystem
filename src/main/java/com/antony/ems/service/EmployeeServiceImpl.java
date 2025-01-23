package com.antony.ems.service;

import com.antony.ems.dto.EmployeeDTO;
import com.antony.ems.mapper.EmployeeMapper;
import com.antony.ems.model.EmployeeModel;
import com.antony.ems.repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employee) {
        log.info("in service");
        EmployeeModel employeeModel = EmployeeMapper.toEmployeeModel(employee);
        EmployeeModel newEmployee = employeeRepo.save(employeeModel);
        return EmployeeMapper.toEmployeeDTO(newEmployee);
    }
}
