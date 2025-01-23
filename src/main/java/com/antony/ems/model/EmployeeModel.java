package com.antony.ems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EmployeeData", schema = "emsBackend")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int employeeId;

    @Column(name="First Name")
    private String employeeFirstName;

    @Column(name="Last Name")
    private String employeeLastName;

    @Column(name="Email")
    private String employeeEmail; // Lombok will generate the getter for this field automatically

}