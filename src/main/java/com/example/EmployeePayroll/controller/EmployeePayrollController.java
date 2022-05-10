package com.example.EmployeePayroll.controller;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import com.example.EmployeePayroll.dto.ResponseDTO;
import com.example.EmployeePayroll.exception.EmployeeNotFound;
import com.example.EmployeePayroll.model.EmployeePayrollData;
import com.example.EmployeePayroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    /**
     * Auto wiring Interface
     */
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * HTTP Method to Create/add Employee to payroll
     * http://localhost:8081/employee/create
     * body-{
     *     "name":"Shardul",
     *     "salary":48000,
     *     "gender":"male",
     *     "startDate":"2020-01-01",
     *     "note":"Hey I am a Software Engineer",
     *     "profilePic":"Photo",
     *     "department":["Sell","HR"]
     * }
     * @param empPayrollDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * HTTP Method to watch list of payroll employee
     * http://localhost:8081/employee/List
     * @return
     */
    @RequestMapping(value = {"/list"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get call Success", employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * HTTP Method call by id
     * http://localhost:8081/employee/get/1
     * @return
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrolIData(@PathVariable(value = "empId") int empId) throws EmployeeNotFound {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData=employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success for id successful ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * HTTP Method to update by id
     * http://localhost:8081/employee/update/1
     * @return
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empId,@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) throws EmployeeNotFound {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * HTTP Method to delete by id
     * http://localhost:8081/employee/delete/1
     * @return
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) throws EmployeeNotFound {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully","Deleted id: "+empId);
        return new  ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    /**
     * HTTP Method retrive by Department
     * http://localhost:8081/employee/department/HR
     * @return
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable String department){
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Department Successful",employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
