package com.coppeltestbackend.crud.services.interfaces;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClaseInterface<T> {
    List<T> getClasesByDepartment(String departamento);
}
