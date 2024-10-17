package com.coppeltestbackend.crud.services.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleInterface<T> {
     List<T> findAll();

     Optional<T> findBySku(Integer sku);

     void save(T t);

     void update (T t);

     void remove(Integer sku);
}
