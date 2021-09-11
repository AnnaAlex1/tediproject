package com.devproject.tediproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConnectionRequestNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ConnectionRequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ConnectionRequestNotFoundHandler(ConnectionRequestNotFoundException ex){
        return ex.getMessage();
    }
}
