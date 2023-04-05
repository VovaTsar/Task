package com.example.test.demo.config;

import com.example.test.demo.service.exception.SearchRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleInternalServerError(Exception ex) {
        log.error(ex.getMessage(), ex);

        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

    @ExceptionHandler(SearchRuntimeException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(SearchRuntimeException ex) {
        log.error(ex.getMessage(), ex);

        return ResponseEntity
                .status(NOT_FOUND)
                .body(ex.getMessage());
    }
}
