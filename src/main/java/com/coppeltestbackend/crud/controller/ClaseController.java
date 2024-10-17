package com.coppeltestbackend.crud.controller;

import com.coppeltestbackend.crud.models.Clase;
import com.coppeltestbackend.crud.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clase")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @GetMapping(value = "/findClases", params = {"departamento"})
    public List<Clase> findClases(@RequestParam(value = "departamento") String departamento){
        return claseService.getClasesByDepartment(departamento);
    }
}
