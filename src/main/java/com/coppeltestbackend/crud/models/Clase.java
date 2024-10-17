package com.coppeltestbackend.crud.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "clase")
public class Clase implements Serializable {
    @Serial
    private static final long serialVersionUID = -8885817712041252438L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Integer id_clase;

    @Column(name = "num_departamento")
    private Integer num_departamento;

    @Column(name = "num_clase")
    private Integer num_clase;

    @Column(name = "nombre_clase")
    private String nombre_clase;

    @Column(name = "num_familia")
    private Integer num_familia;

    public Clase(){}

    public Integer getId_clase() {
        return id_clase;
    }

    public void setId_clase(Integer id_clase) {
        this.id_clase = id_clase;
    }

    public Integer getNumDepartamento() {
        return num_departamento;
    }

    public void setNumDepartamento(Integer numDepartamento) {
        this.num_departamento = numDepartamento;
    }

    public Integer getNumClase() {
        return num_clase;
    }

    public void setNumClase(Integer numClase) {
        this.num_clase = numClase;
    }

    public String getNombre() {
        return nombre_clase;
    }

    public void setNombre(String nombre) {
        this.nombre_clase = nombre;
    }

    public Integer getNum_familia() {
        return num_familia;
    }

    public void setNum_familia(Integer num_familia) {
        this.num_familia = num_familia;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id_clase=" + id_clase +
                ", numDepartamento=" + num_departamento +
                ", numClase=" + num_clase +
                ", nombre='" + nombre_clase + '\'' +
                ", num_familia=" + num_familia +
                '}';
    }
}
