package com.example.EmployeePayroll.exception;

import com.example.EmployeePayroll.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleInvalidExceptions(MethodArgumentNotValidException error) {
        List<String> errorMessage = error.getAllErrors().stream()
                .map(errorObject -> errorObject.getDefaultMessage())
                .collect(Collectors.toList());

        ResponseDTO response = new ResponseDTO("Exception While processing REST Request", errorMessage);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeeNotFound exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST request",exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }


}
