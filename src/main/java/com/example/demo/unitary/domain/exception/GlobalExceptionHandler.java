package com.example.demo.unitary.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TeamNotFoundException.class)
    public final ResponseEntity<Object> teamNotFound(final TeamNotFoundException teamNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Time com id " + teamNotFoundException.getIdTeam() + " não existe");
    }

}
