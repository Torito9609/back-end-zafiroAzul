package com.proyectofinal.backend_zafiro_azul.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPedido;
    private Long idUsuario;
    private Long idUsuarioTemp;
    private Long idEstadoPedido;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaPedido;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPedido;

    public Pedido(Date fechaPedido, Long idPedido, Long idUsuario, Long idUsuarioTemp, Long idEstadoPedido, BigDecimal totalPedido) {
        this.fechaPedido = fechaPedido;
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idUsuarioTemp = idUsuarioTemp;
        this.totalPedido = totalPedido;
        this.idEstadoPedido = idEstadoPedido;
    }

    public Date getFechaPedido() {return fechaPedido;}

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

    public Long getIdEstadoPedido(){return idEstadoPedido;}

    private void setIdEstadoPedido(Long idEstado){this.idEstadoPedido = idEstado;}

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
}
