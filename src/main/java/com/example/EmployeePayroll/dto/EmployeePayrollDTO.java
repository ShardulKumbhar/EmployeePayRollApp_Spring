package com.example.EmployeePayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
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

    @Pattern(regexp = "male|female",message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "start should not be empty")
    @PastOrPresent(message = "start date should be past or todays")
    public LocalDate startDate;

    @NotBlank(message = "note should not be empty")
    public String note;

    @NotBlank(message = "profile pic should not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
    public List<String> departments;

}
