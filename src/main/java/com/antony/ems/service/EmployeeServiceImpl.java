package com.antony.ems.service;

import com.antony.ems.dto.EmployeeDTO;
import com.antony.ems.exception.ResourceNotFoundException;
import com.antony.ems.mapper.EmployeeMapper;
import com.antony.ems.model.EmployeeModel;
import com.antony.ems.repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public EmployeeDTO getEmployee(int id) {

        EmployeeModel employeeModel = employeeRepo.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("Resource not found with id "+id)

        );

        return EmployeeMapper.toEmployeeDTO(employeeModel);
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {

        EmployeeModel findEmployee = employeeRepo.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("Resource not found with id "+id)
        );

        findEmployee.setEmployeeFirstName(employeeDTO.getFirstName());
        findEmployee.setEmployeeLastName(employeeDTO.getLastName());
        findEmployee.setEmployeeEmail(employeeDTO.getEmail());

        EmployeeModel updatedEmployee = employeeRepo.save(findEmployee);

        return EmployeeMapper.toEmployeeDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(int id) {

        EmployeeModel findEmployee = employeeRepo.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("Resource not found with id "+id)
        );

        employeeRepo.delete(findEmployee);

    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeModel> employeeModelList = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (EmployeeModel employeeModel:employeeModelList) {
            employeeDTOList.add(EmployeeMapper.toEmployeeDTO(employeeModel));
        }

        return employeeDTOList;
    }


}
