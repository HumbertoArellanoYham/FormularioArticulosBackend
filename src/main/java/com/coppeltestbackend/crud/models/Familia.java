package com.coppeltestbackend.crud.models;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "familia")
public class Familia implements Serializable {

    private static final long serialVersionUID = -8885817712041252438L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_familia;

    private String nombre_familia;

    private Integer num_familia;


    public Familia(){}

    // Getters and setters

    public Integer getId_familia() {
        return id_familia;
    }

    public void setId_familia(Integer id_familia) {
        this.id_familia = id_familia;
    }

    public String getNombre_familia() {
        return nombre_familia;
    }

    public void setNombre_familia(String nombre_familia) {
        this.nombre_familia = nombre_familia;
    }

    public Integer getNum_familia() {
        return num_familia;
    }

    public void setNum_familia(Integer num_familia) {
        this.num_familia = num_familia;
    }
   
    @Override
    public String toString() {
    return "Familia [id_familia=" + id_familia + ", nombre_familia=" + nombre_familia + ", num_familia=" + num_familia
            + "]";
    } 

}
