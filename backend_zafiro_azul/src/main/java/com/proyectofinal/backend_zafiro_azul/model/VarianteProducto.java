package com.proyectofinal.backend_zafiro_azul.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class VarianteProducto {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long idVariante;
    private Long idProducto;
    private String tamañoVariante;
    private BigDecimal precioVariante;
    private int stockVariante;


    public VarianteProducto(Long idVariante, Long idProducto, String tamañoVariante, BigDecimal precioVariante, int stockVariante) {
        this.idVariante = idVariante;
        this.idProducto = idProducto;
        this.tamañoVariante = tamañoVariante;
        this.precioVariante = precioVariante;
        this.stockVariante = stockVariante;
    }

    public VarianteProducto() {
    }

    public Long getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(Long idVariante) {
        this.idVariante = idVariante;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getTamañoVariante() {
        return tamañoVariante;
    }

    public void setTamañoVariante(String tamañoVariante) {
        this.tamañoVariante = tamañoVariante;
    }

    public BigDecimal getPrecioVariante() {
        return precioVariante;
    }

    public void setPrecioVariante(BigDecimal precioVariante) {
        this.precioVariante = precioVariante;
    }

    public int getStockVariante() {
        return stockVariante;
    }

    public void setStockVariante(int stockVariante) {
        this.stockVariante = stockVariante;
    }
}
