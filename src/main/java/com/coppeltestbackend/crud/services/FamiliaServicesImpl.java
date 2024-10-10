package com.coppeltestbackend.crud.services;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import com.coppeltestbackend.crud.models.Familia;
import com.coppeltestbackend.crud.repositories.FamiliaRepository;

import jakarta.transaction.Transactional;

@Service
public class FamiliaServicesImpl {
    
    @Autowired
    private FamiliaRepository familiaRepository;

    public FamiliaServicesImpl(FamiliaRepository repositoryFamilia){
        familiaRepository = repositoryFamilia;
    }

    @Transactional()
    @ReadOnlyProperty()
    public Iterable<Familia> findAll(){
        Iterable<Familia> result = familiaRepository.findAll();

        return result;
    }

    @Transactional
    public Familia save(Familia familia){
        return familiaRepository.save(familia);
    }
}
