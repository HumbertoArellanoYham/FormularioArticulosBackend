package com.coppeltestbackend.crud.components;

import com.coppeltestbackend.crud.models.MultiplesFamilias;
import com.coppeltestbackend.crud.services.FamiliaServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            System.out.println("Recibiendo familias: " + familias.getFamilias());
            familias.getFamilias().forEach(fam -> {
                familiaServicesImpl.save(fam);
                System.out.println("Guardando familia: " + fam.getNombre_familia() + " con num_familia: " + fam.getNum_familia());   
            });
            
            // Devolver una respuesta de éxito con un mensaje
            return ResponseEntity.ok("Familias guardadas con éxito");
        } catch (Exception e) {
            // Devolver una respuesta de error con el mensaje de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al guardar las familias: " + e.getMessage());
        }
    }
    
    
}
