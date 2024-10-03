package com.coppeltestbackend.crud.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleServices<T> {
     List<T> findAll();

     T findBySku(Integer sku);

     void save(T t);

     void remove(Integer sku);

     List<String> departamento();
}
