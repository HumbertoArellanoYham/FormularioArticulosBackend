package com.coppeltestbackend.crud.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    @Serial
    private static final long serialVersionUID = -8885817712041252438L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer id_departamento;

    @Column(name = "num_departamento")
    private Integer numDepartamento;

    @Column(name = "nombre_departamento")
    private String nombreDepartamento;

    @Column(name = "num_clase")
    private Integer numClase;

    public Departamento(){}

    // Getters and setters

    public Integer getIdDepartamento() {
        return id_departamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.id_departamento = idDepartamento;
    }

    public Integer getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(Integer numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getNumClase() {
        return numClase;
    }

    public void setNumClase(Integer numClase) {
        this.numClase = numClase;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + id_departamento +
                ", numDepartamento=" + numDepartamento +
                ", nombreDepartamento=" + nombreDepartamento +
                ", numClase=" + numClase +
                '}';
    }
}
