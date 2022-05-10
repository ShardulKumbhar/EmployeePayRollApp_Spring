package com.example.EmployeePayroll.model;

import com.example.EmployeePayroll.dto.EmployeePayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll_data")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    @Column(name = "start_date")
    private LocalDate startDate;
    private String note;
    @Column(name = "profile_pic")
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){

        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    /**
     * Assigning to Entity data
     * @param employeePayrollDTO
     */
    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.department = employeePayrollDTO.department;
    }

}
