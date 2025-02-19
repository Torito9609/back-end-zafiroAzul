package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long idDetalle;
    Long idPedido;
    Long idVariante;
    @Column(nullable = false)
    Integer cantidadVariante;
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal precioUnitario;
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal subTotal;

    public DetallePedido(Long idDetalle, Long idPedido, Long idVariante, Integer cantidadVariante, BigDecimal precioUnitario, BigDecimal subTotal) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idVariante = idVariante;
        this.cantidadVariante = cantidadVariante;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public DetallePedido() {
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(Long idVariante) {
        this.idVariante = idVariante;
    }

    public Integer getCantidadVariante() {
        return cantidadVariante;
    }

    public void setCantidadVariante(Integer cantidadVariante) {
        this.cantidadVariante = cantidadVariante;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
