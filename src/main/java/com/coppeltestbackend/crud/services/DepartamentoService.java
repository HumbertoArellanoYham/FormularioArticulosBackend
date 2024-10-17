package com.coppeltestbackend.crud.services;

import com.coppeltestbackend.crud.models.Departamento;
import com.coppeltestbackend.crud.repositories.DepartamentoRepository;
import com.coppeltestbackend.crud.services.interfaces.DepartamentoInterface;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@EnableCaching
public class DepartamentoService implements DepartamentoInterface<Departamento> {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository){
        this.departamentoRepository = departamentoRepository;
    }

    @Cacheable(value = "getDepartamentos")
    @Transactional
    @Override
    public List<Departamento> getDepartamentos() {
        return departamentoRepository.getDepartamentos();
    }
}
