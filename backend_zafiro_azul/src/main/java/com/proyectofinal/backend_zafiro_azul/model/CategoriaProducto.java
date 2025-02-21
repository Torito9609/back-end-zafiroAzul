package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategoria;

    @Column(nullable = false)
    String nombreCategoria;

    @Column(nullable = false)
    String descripcionCategoria;

    @ManyToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
    private List<Producto> productos;

    public CategoriaProducto(String nombreCategoria, String descripcionCategoria) {
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
