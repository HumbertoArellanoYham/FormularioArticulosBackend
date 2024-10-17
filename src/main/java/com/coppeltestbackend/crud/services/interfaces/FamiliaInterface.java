package com.coppeltestbackend.crud.services.interfaces;

import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public interface FamiliaInterface<T> {
    Iterable<T> findAll();

    T save(T t);

    List<T> findAllFamilies(String departamento, String clase);
}
