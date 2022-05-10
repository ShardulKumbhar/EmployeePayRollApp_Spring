package com.example.EmployeePayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public @ToString class EmployeePayrollDTO {

    @NotNull(message = "ERROR: Name cannot be null!")
    @NotEmpty(message = "ERROR: Name cannot be empty!")
    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid name!")
    public String name;

    @NotNull(message = "ERROR: Salary cannot be null!")
    @Min(value = 5000, message = "ERROR: Please enter a salary greater than 5000")
    public long salary;

    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> departments;


}
