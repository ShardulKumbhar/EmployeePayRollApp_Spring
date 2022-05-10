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

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollDataList.get(empId-1);//as arraylist index is starts from 0
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollDataList.size()+1, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);//adds in employee list
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.remove(empId-1);
    }
}
