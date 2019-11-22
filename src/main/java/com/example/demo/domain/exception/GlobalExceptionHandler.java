package com.example.demo.domain.exception;

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

    @ExceptionHandler(MemberNotFoundException.class )
    public  final ResponseEntity<String> memberNotFound(final MemberNotFoundException memberNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Membro com id " + memberNotFoundException.getIdMember() + " não existe");
    }

}
