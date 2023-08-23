package com.sample.demo.controllers;

import com.sample.demo.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Response<Object>> handleDataNotFoundException(DataNotFoundException e) {
        Response<Object> responseObject = new Response<>();
        responseObject.setCode(e.getErrorCode());

        return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }
}
