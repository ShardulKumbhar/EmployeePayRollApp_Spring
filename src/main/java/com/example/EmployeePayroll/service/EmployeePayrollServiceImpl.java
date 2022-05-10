package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import com.example.EmployeePayroll.model.EmployeePayrollData;
import com.example.EmployeePayroll.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Tom",4000)));
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Tom", 6000));
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId,new EmployeePayrollDTO("Tom",8000));
    }
}
