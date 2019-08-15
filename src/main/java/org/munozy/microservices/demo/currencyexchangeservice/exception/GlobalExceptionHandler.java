package org.munozy.microservices.demo.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ExceptionReponse exceptionReponse = ExceptionReponse
                .of(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionReponse, HttpStatus.NOT_FOUND);
    }
}
