package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import com.example.EmployeePayroll.exception.EmployeeNotFound;
import com.example.EmployeePayroll.exception.ExceptionHandlers;
import com.example.EmployeePayroll.model.EmployeePayrollData;
import com.example.EmployeePayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository ;


    /**
     * Method to Watch all data Stored
     * @return
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    /**
     * Method to get employee by id
     * @param empId
     * @return
     * @throws EmployeeNotFound
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) throws EmployeeNotFound {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(()->new EmployeeNotFound(("Employee with employeeOd "+empId+ "does not exists...")));
    }

    /**
     * Method to Store Employee data in DB
     * @param employeePayrollDTO
     * @return
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO)  {
        EmployeePayrollData empData = null;
       empData = new EmployeePayrollData(employeePayrollDTO);
       log.debug("Emp Data : " +empData.toString());
       return employeePayrollRepository.save(empData);
    }

    /**
     * Method to Update Data in DB
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeNotFound {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    /**
     * Method to delete Data from DB
     */
    @Override
    public void deleteEmployeePayrollData(int empId) throws EmployeeNotFound {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);

    }

    /**
     * Method to get by department name
     */
    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }

}
