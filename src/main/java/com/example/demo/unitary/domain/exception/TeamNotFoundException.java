package com.example.demo.unitary.domain.exception;

import lombok.Getter;

@Getter
public class TeamNotFoundException extends Exception {

    private Long idTeam;

    public TeamNotFoundException(Long idTeam) {
        super();
        this.idTeam = idTeam;
    }

}
