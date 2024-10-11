package com.coppeltestbackend.crud.models;

import java.util.List;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

@Component
public class MultiplesFamilias implements Serializable {
    private List<Familia> familias;

    public MultiplesFamilias(){
        familias = new ArrayList<>();
    }

    public List<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(List<Familia> familias) {
        this.familias = familias;
    }

    public void append(Familia familia){
        this.familias.add(familia);
    }
}
