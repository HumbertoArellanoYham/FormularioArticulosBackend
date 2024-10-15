package com.coppeltestbackend.crud.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "articulo")
@Access(value = AccessType.FIELD)
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="sku")
    private Integer sku;

    @Column
    private String nombre;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String departamento;
    @Column
    private String clase;
    @Column
    private String familia;
    @Column
    private Date fecha_alta;
    @Column
    private Integer stock;
    @Column
    private Integer cantidad;
    @Column
    private Integer descontinuado;
    @Column
    private Date fecha_baja;

    public Article(){}

    // Getters and setters

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Integer descontinuado) {
        this.descontinuado = descontinuado;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    @Override
    public String toString() {
        return "Article{" +
                "sku=" + sku +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", departamento='" + departamento + '\'' +
                ", clase='" + clase + '\'' +
                ", familia='" + familia + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", stock=" + stock +
                ", cantidad=" + cantidad +
                ", descontinuado=" + descontinuado +
                ", fecha_baja=" + fecha_baja +
                '}';
    }
}
