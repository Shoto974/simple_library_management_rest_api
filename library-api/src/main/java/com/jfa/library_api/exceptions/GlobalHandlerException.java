package com.jfa.library_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerBookNotFoundException(BookNotFoundException ex){
        return new ResponseEntity<>(Map.of("error", ex.getMessage()),HttpStatus.NOT_FOUND);
    }
}
