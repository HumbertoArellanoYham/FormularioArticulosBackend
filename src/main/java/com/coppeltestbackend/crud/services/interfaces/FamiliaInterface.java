package com.coppeltestbackend.crud.services.interfaces;

import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public interface FamiliaInterface<T> {
    Iterable<T> findAll();

    T save(T t);
}
