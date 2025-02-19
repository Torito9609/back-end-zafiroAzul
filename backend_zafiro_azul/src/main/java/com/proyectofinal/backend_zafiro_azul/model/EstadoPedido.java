package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

@Entity
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long idEstado;
    @Column(nullable = false)
    String nombreEstado;

    public EstadoPedido(Long idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public EstadoPedido() {
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
