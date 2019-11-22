package com.example.demo.domain.exception;

import lombok.Getter;

@Getter
public class MemberNotFoundException extends Exception {

    private Long idMember;

    public MemberNotFoundException(Long idMember) {
        super();
        this.idMember = idMember;
    }

}
