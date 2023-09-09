package com.interview.demo.advice;

import com.interview.demo.customexception.BussinessException;
import com.interview.demo.customexception.EmptyInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<?> handleEmptyException(EmptyInputException emptyInputException) {
        return new ResponseEntity<>(emptyInputException, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<?> handleBussinessException(BussinessException bussinessException) {
        return new ResponseEntity<>(bussinessException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("The give Employe id is Not present in Db", HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<>("please choose correct method",HttpStatus.METHOD_NOT_ALLOWED);
    }
}
