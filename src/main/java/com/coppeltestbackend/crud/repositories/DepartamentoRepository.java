package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Departamento;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {
    @Query(value = "CALL departamentos()", nativeQuery = true)
    List<Departamento> getDepartamentos();
}
