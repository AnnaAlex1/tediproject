package com.devproject.tediproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PictureNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PictureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pictureNotFoundHandler(PictureNotFoundException ex){
        return ex.getMessage();
    }
}
