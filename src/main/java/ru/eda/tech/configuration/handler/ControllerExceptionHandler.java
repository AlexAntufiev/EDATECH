package ru.eda.tech.configuration.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.eda.tech.controller.api.Error;
import ru.eda.tech.controller.api.ResponseContent;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = {RuntimeException.class})
    ResponseEntity<ResponseContent<?>> handleBaseExceptions(RuntimeException e) {
        log.error("Can't finished request", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseContent.failed(
                        Error.of("TechnicalError", "Request was failed with exception")));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    ResponseEntity<ResponseContent<?>> handleBaseExceptions(Exception e) {
        log.error("Can't finished request", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ResponseContent.failed(
                        Error.of("ValidationFailure", "Request Validation failed with exception")));
    }
}
