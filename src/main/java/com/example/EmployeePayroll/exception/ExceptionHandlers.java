package com.example.EmployeePayroll.exception;

import com.example.EmployeePayroll.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {
    private static final String message = "Exception While processing REST Request";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleInvalidExceptions(MethodArgumentNotValidException error) {
        List<String> errorMessage = error.getAllErrors().stream()
                .map(errorObject -> errorObject.getDefaultMessage())
                .collect(Collectors.toList());

        ResponseDTO response = new ResponseDTO(message, errorMessage);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeeNotFound exception){
        ResponseDTO responseDTO = new ResponseDTO(message,exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        log.error("invalid date format",exception);
        ResponseDTO responseDTO = new ResponseDTO(message,"Should have date in the format dd MM yyyy");
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }


}
