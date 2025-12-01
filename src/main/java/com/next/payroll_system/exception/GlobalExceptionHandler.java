package com.next.payroll_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    // ------------------- CUSTOM NOT FOUND -------------------
    @ExceptionHandler(ResourceNotFoundExecption.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundExecption ex){
      Map<String ,Object> response = new HashMap<>();
      response.put("status",404);
      response.put("error",ex.getMessage());
      response.put("timestamp", LocalDateTime.now());
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    // ------------------- VALIDATION ERRORS -------------------
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex){
        Map<String, Object> errors= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err->errors.put(err.getField(),err.getDefaultMessage()));
          return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }

}
