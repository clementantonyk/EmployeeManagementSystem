package com.antony.ems.mapper;

import com.antony.ems.dto.EmployeeDTO;
import com.antony.ems.model.EmployeeModel;

public class EmployeeMapper {

    // fetching info from the db to show to the user

    public static EmployeeDTO toEmployeeDTO(EmployeeModel employeeModel){

        return new EmployeeDTO(

                employeeModel.getEmployeeId(),
                employeeModel.getEmployeeFirstName(),
                employeeModel.getEmployeeLastName(),
                employeeModel.getEmployeeEmail()
        );

    }

    // when the user updates or register, the changes need to store in db
    // This mapper is used to do that

    public static EmployeeModel toEmployeeModel(EmployeeDTO employeeDTO){

        return new EmployeeModel(

                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );

    }


}
