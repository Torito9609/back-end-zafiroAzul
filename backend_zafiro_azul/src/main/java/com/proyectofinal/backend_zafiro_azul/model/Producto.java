package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long idProducto;
    @Column(nullable = false)
    private String nombreProducto;
    @Column(nullable = false)
    private String imagenProducto;

    public Producto(Long idProducto, String imagenProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.imagenProducto = imagenProducto;
        this.nombreProducto = nombreProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
