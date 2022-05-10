package com.example.EmployeePayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    /**
     * To response with Message and data
     */
    private String message;
    private Object data;
}
