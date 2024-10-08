package com.coppeltestbackend.crud.components;

import com.coppeltestbackend.crud.models.Familia;
import com.coppeltestbackend.crud.repositories.ArticleRepository;
import com.coppeltestbackend.crud.repositories.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaComponent {

    private final FamiliaRepository familiaRepository;

    @Autowired
    public FamiliaComponent(FamiliaRepository familiaRepository){
        this.familiaRepository = familiaRepository;
    }

    @GetMapping("/hello")
    public String happyCase(){
        return "Success Get";
    }

    @PostMapping("/addFamilia")
    public ResponseEntity<?> addFamilia(@RequestBody List<Familia> familia){
        familiaRepository.saveAll(familia);

        return ResponseEntity.status(HttpStatus.OK).body("Send");
    }
}
