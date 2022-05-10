package com.example.EmployeePayroll.repository;

import com.example.EmployeePayroll.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {

    /**
     * Query to find employee by department
     * @param department
     * @return
     */
    @Query(value = "select * from employee_payroll_data, employee_department where employee_id = id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

}