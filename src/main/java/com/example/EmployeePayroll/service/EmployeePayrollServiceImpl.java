package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import com.example.EmployeePayroll.model.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        log.info("Saving a new employee record in the db");
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollDataList.size()+1, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);//adds in employee list
        return employeePayrollData;
    }

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        log.info("Retrieving employee information from the db");
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        log.info("Retrieving the employee data by employee ID");
        return employeePayrollDataList.get(empId-1);//as arraylist index is starts from 0
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, @Valid EmployeePayrollDTO employeePayrollDTO) {
        log.info("Updating the employee data");
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        log.info("Deleting an employee record");
        employeePayrollDataList.remove(empId-1);
    }
}
