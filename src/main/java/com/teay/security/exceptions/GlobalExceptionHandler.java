package com.teay.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponse> handleExpiredTokenException(InvalidTokenException ex){
        ErrorResponse error = new ErrorResponse("Invalid JWT Token", HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericExceptions(Exception ex){
        ErrorResponse error = new ErrorResponse(
                "An Error Occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
