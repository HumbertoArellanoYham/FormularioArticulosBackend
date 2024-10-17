package com.coppeltestbackend.crud.controller;

import com.coppeltestbackend.crud.models.Departamento;
import com.coppeltestbackend.crud.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/")
    public List<Departamento> findDepartment(){
        return departamentoService.getDepartamentos();
    }
}
