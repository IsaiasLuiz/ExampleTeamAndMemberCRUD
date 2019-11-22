package com.example.demo.domain;

public interface MapperConverter<T, R> {

    R converterToResponse(T t);
}
