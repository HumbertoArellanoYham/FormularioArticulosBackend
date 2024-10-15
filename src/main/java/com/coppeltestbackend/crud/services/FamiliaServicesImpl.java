package com.coppeltestbackend.crud.services;

import com.coppeltestbackend.crud.services.interfaces.FamiliaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coppeltestbackend.crud.models.Familia;
import com.coppeltestbackend.crud.repositories.FamiliaRepository;

import java.util.Iterator;

@EnableCaching
@Service
public class FamiliaServicesImpl implements FamiliaInterface<Familia> {
    
    @Autowired
    private FamiliaRepository familiaRepository;

    public FamiliaServicesImpl(FamiliaRepository repositoryFamilia){
        familiaRepository = repositoryFamilia;
    }

    @Override
    @Cacheable(value="familias")
    @Transactional(readOnly = true)
    public Iterable<Familia> findAll(){
        return familiaRepository.findAll();
    }

    @Transactional
    @Override
    public Familia save(Familia familia){
        return familiaRepository.save(familia);
    }
}
