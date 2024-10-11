package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Familia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080/")
@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Integer> {
}
