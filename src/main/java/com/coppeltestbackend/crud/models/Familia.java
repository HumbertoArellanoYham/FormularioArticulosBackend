package com.coppeltestbackend.crud.models;


import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {

    @Serial
    private static final long serialVersionUID = -8885817712041252438L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Integer id_familia;

    @Column(name = "num_clase")
    private Integer numClase;

    @Column
    private String nombre_familia;

    @Column
    private Integer num_familia;

    @Column(name = "num_departamento")
    private Integer numDepartamento;

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

    public Integer getNumClase() {
        return numClase;
    }

    public void setNumClase(Integer numClase) {
        this.numClase = numClase;
    }

    public Integer getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(Integer numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    @Override
    public String toString() {
    return "Familia [id_familia=" + id_familia + ", nombre_familia=" + nombre_familia + ", num_familia=" + num_familia
            + "]";
    } 

}
