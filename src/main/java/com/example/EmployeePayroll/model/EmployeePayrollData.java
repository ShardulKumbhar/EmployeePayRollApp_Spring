package com.example.EmployeePayroll.model;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class EmployeePayrollData {

    @Id
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO){
        this.employeeId=empId;
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
    }

}
