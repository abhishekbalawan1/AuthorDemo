package com.example.demo.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exceptionHandler(CustomException customException){
        return new ResponseEntity<>(customException.getErrorDescription(), HttpStatus.BAD_REQUEST);
    }
}
