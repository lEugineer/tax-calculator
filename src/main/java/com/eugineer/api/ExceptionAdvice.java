package com.eugineer.api;

import com.eugineer.dto.ErrorResponse;
import com.eugineer.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundExceptionHandler( EntityNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse( e.getMessage(), e.status ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> nullPointerExceptionHandler( NullPointerException e) {
        return new ResponseEntity<>(new ErrorResponse( e.getMessage(), 409), HttpStatus.CONFLICT);
    }
}
