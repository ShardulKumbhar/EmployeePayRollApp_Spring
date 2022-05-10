package com.example.EmployeePayroll.repository;

import com.example.EmployeePayroll.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeePayrollData,Long> {
}
