package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

@Entity
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long idCategoria;
    @Column(nullable = false)
    String nombreCategoria;
    @Column(nullable = false)
    String descripcionCategoria;

    public CategoriaProducto(Long idCategoria, String nombreCategoria, String descripcionCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public CategoriaProducto() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}
