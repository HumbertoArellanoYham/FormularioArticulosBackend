package com.coppeltestbackend.crud.services;

import com.coppeltestbackend.crud.services.interfaces.FamiliaInterface;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coppeltestbackend.crud.models.Familia;
import com.coppeltestbackend.crud.repositories.FamiliaRepository;

import java.util.Iterator;
import java.util.List;

@EnableCaching
@Service
public class FamiliaServices implements FamiliaInterface<Familia> {
    
    @Autowired
    private final FamiliaRepository familiaRepository;

    public FamiliaServices(FamiliaRepository repositoryFamilia){
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

    //
    @Transactional(readOnly = true)
    @Cacheable(value = "findAllFamilies")
    @Override
    public List<Familia> findAllFamilies(String departamento, String clase){
        return familiaRepository.findAllFamilies(departamento, clase);
    }
}
