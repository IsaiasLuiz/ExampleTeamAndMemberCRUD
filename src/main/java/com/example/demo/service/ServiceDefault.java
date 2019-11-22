package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.exception.TeamNotFoundException;

public interface ServiceDefault<T, R> {

    void save(final T t) throws TeamNotFoundException;

    List<R> listAll(final Integer page);

    R searchforId(final Long id);
}
