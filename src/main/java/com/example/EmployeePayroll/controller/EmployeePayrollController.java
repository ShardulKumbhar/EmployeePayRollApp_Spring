package com.example.EmployeePayroll.controller;

import com.example.EmployeePayroll.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody Employee employee) {
        return new ResponseEntity<String>("Created Employee Payroll Data for: " + employee, HttpStatus.OK);
    }

    @RequestMapping(value = {"/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrolIData(@PathVariable(value = "empId") int empId) {
        return new ResponseEntity<String>("Get Call Success for id: " + empId, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody Employee employee){
        return new ResponseEntity<String>("Updated Employee Payroll Data for: "+employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Delete Call Success for id: " + empId, HttpStatus.OK);
    }

}
