package com.coppeltestbackend.crud.components;

import com.coppeltestbackend.crud.models.MultiplesFamilias;
import com.coppeltestbackend.crud.services.FamiliaServicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familia")
public class FamiliaComponent {

    private final FamiliaServicesImpl familiaServicesImpl;

    @Autowired
    private MultiplesFamilias multiplesFamilias;

    public FamiliaComponent(FamiliaServicesImpl familiaServices){
        this.familiaServicesImpl = familiaServices;
    }

    @GetMapping("/findAllFamilias")
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
        if(familias.getFamilias().size() == 0 || familias == null){  
            return ResponseEntity.badRequest().build();
        }

        familias.getFamilias().forEach(fam -> {
                familiaServicesImpl.save(fam);
        });

        return ResponseEntity.ok().build();
    }
}
