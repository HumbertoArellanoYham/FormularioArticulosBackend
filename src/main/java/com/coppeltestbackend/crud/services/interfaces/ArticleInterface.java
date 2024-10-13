package com.coppeltestbackend.crud.services.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleInterface<T> {
     List<T> findAll();

     Optional<T> findBySku(Integer sku);

     T save(T t);

     void remove(Integer sku);

     List<String> departamento();

     List<String> clase(String departamento);

     List<String> familia(String clase);
}
