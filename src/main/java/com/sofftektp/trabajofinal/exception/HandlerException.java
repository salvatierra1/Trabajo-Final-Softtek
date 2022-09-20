package com.sofftektp.trabajofinal.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestException(BadRequestException badRequestException){
        return ResponseEntity.status(400).body(badRequestException.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<String> NotFoundRequestException(NotFoundException notFoundException){
        return ResponseEntity.status(404).body(notFoundException.getMessage());
    }

}
