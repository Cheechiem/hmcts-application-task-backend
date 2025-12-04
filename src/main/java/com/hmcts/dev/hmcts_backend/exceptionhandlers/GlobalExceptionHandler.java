package com.hmcts.dev.hmcts_backend.exceptionhandlers;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class, ConstraintViolationException.class })
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(Exception ex){
        Map<String, Object> response = new HashMap<>();
        List<String> messages = new ArrayList<>();

        if (ex instanceof MethodArgumentNotValidException manv) {
            manv.getBindingResult().getFieldErrors()
                    .forEach(error -> messages.add(error.getDefaultMessage()));
        }

        if (ex instanceof ConstraintViolationException cve) {
            cve.getConstraintViolations()
                    .forEach(error -> messages.add(error.getMessage()));
        }

        response.put("status", 400);
        response.put("message", messages);

        return ResponseEntity.badRequest().body(response);
    }
}
