package com.example.demo.unitary.domain;

public interface MapperConverter<T, R> {

    R converterToResponse(T t);
}
