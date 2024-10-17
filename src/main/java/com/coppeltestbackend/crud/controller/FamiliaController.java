package com.coppeltestbackend.crud.controller;

import com.coppeltestbackend.crud.models.Familia;
import com.coppeltestbackend.crud.models.components.MultiplesFamilias;
import com.coppeltestbackend.crud.services.FamiliaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {
    private final FamiliaServices familiaServicesImpl;
    @Autowired
    private MultiplesFamilias multiplesFamilias;

    @Autowired
    public FamiliaController(FamiliaServices familiaServices){
        this.familiaServicesImpl = familiaServices;
    }

    @GetMapping(value = "/findFamilies", params = {"departamento", "clase"})
    public List<Familia> findFamilies(@RequestParam(value = "departamento") String departamento, @RequestParam(value = "clase") String clase){
        return familiaServicesImpl.findAllFamilies(departamento, clase);
    }

    @GetMapping(value = "/findAllFamilias")
    public MultiplesFamilias findAllFamilias(){
        multiplesFamilias = new MultiplesFamilias();

        familiaServicesImpl.findAll().forEach(multiplesFamilias::append);

        return multiplesFamilias;
    }

    @PostMapping("/addFamilias")
    public ResponseEntity<?> addFamilia(@RequestBody MultiplesFamilias familias){
        return checkFunctionSaveAdd(familias);
    }
    
    private ResponseEntity<?> checkFunctionSaveAdd(MultiplesFamilias familias){
        if(familias.getFamilias().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        familias.getFamilias().forEach(familiaServicesImpl::save);

        return ResponseEntity.ok().build();
    }
}
