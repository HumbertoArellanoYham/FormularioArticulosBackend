package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Familia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Integer> {
    @Query(value = "CALL familiasPorDepartamentoClase(:departmentName, :className)", nativeQuery = true)
    List<Familia> findAllFamilies(@Param(value = "departmentName") String departmentName, @Param(value="className") String className);
}
