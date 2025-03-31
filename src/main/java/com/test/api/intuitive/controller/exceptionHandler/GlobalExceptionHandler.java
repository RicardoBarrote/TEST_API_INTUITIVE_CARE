package com.test.api.intuitive.controller.exceptionHandler;

import com.test.api.intuitive.infrastructure.logger.LoggerSlf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler implements LoggerSlf4j {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> genericException(Exception e){
        LOGGER().error("Erro generico 'GRAVE' - mensagem: {}, causa: {}, stackTrace: {}", e.getMessage(), e.getCause(), e.getStackTrace());
        ResponseError responseError = new ResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), Instant.now());
        return new ResponseEntity<>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ResponseError> fileNotFoundException(FileNotFoundException e){
        LOGGER().error("Erro FileNotFoundException- mensagem: {}, causa: {}, stackTrace: {}", e.getMessage(), e.getCause(), e.getStackTrace());
        ResponseError responseError = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value(), Instant.now());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ResponseError> IOException(IOException e){
        LOGGER().error("Error IOExecption - mensagem: {}, causa: {}, stackTrace: {}", e.getMessage(), e.getCause(), e.getStackTrace());
        ResponseError responseError = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value(), Instant.now());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }
}
