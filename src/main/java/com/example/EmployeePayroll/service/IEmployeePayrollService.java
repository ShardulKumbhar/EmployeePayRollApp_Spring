package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import com.example.EmployeePayroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
