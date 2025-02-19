package com.proyectofinal.backend_zafiro_azul.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPedido;
    private Long idUsuario;
    private Long idUsuarioTemp;


    private Date fechaPedido;
    private BigDecimal totalPedido;

    public Pedido(Date fechaPedido, Long idPedido, Long idUsuario, Long idUsuarioTemp, BigDecimal totalPedido) {
        this.fechaPedido = fechaPedido;
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idUsuarioTemp = idUsuarioTemp;
        this.totalPedido = totalPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuarioTemp() {
        return idUsuarioTemp;
    }

    public void setIdUsuarioTemp(Long idUsuarioTemp) {
        this.idUsuarioTemp = idUsuarioTemp;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
}
