package com.example.EmployeePayroll.model;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO){
        this.employeeId=empId;
        this.updateEmployeePayrollDTO(employeePayrollDTO);
    }

    private void updateEmployeePayrollDTO(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;
    }
}
