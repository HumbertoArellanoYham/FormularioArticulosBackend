package com.coppeltestbackend.crud.repositories;

import com.coppeltestbackend.crud.models.Clase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface ClaseRepository extends CrudRepository<Clase, Integer> {
    @Query(value = "CALL GetUniqueClassesByDepartmentName(:departmentName)", nativeQuery = true)
    List<Clase> clases(@Param("departmentName") String departmentName);
}