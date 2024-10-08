package com.coppeltestbackend.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Familia")
public class Familia {
    @Id
    @Column(name = "id_familia")
    private Integer id;

    @Column(name= "nombre_familia")
    private String name;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
