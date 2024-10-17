package com.coppeltestbackend.crud.services.interfaces;

import com.coppeltestbackend.crud.models.Departamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentoInterface<Departamento> {
    List<Departamento> getDepartamentos();
}
