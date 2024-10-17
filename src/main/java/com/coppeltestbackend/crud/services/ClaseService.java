package com.coppeltestbackend.crud.services;

import com.coppeltestbackend.crud.models.Clase;
import com.coppeltestbackend.crud.repositories.ClaseRepository;
import com.coppeltestbackend.crud.services.interfaces.ClaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableCaching
@Service
public class ClaseService implements ClaseInterface<Clase> {

    private final ClaseRepository claseRepository;

    @Autowired
    public ClaseService(ClaseRepository claseRepository){
        this.claseRepository = claseRepository;
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "getClases")
    @Override
    public List<Clase> getClasesByDepartment(String departamento) {
        return claseRepository.clases(departamento);
    }
}
