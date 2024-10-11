package com.coppeltestbackend.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coppeltestbackend.crud.models.Familia;
import com.coppeltestbackend.crud.repositories.FamiliaRepository;

@Service
public class FamiliaServicesImpl {
    
    @Autowired
    private FamiliaRepository familiaRepository;

    public FamiliaServicesImpl(FamiliaRepository repositoryFamilia){
        familiaRepository = repositoryFamilia;
    }

    @Cacheable(value="findAll")
    @Transactional(readOnly = true)
    public Iterable<Familia> findAll(){
        Iterable<Familia> result = familiaRepository.findAll();

        return result;
    }

    @Transactional
    public Familia save(Familia familia){
        return familiaRepository.save(familia);
    }
}
