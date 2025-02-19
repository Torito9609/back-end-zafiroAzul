package com.proyectofinal.backend_zafiro_azul.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class VarianteProducto {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long idVariante;
    @Column(nullable = false)
    private Long idProducto;
    @Column(name = "TAMANO_VARIANTE", nullable = false)
    private String tamanoVariante;
    @Column(nullable = false)
    private BigDecimal precioVariante;
    @Column(nullable = false)
    private int stockVariante;


    public VarianteProducto(Long idVariante, Long idProducto, String tamanoVariante, BigDecimal precioVariante, int stockVariante) {
        this.idVariante = idVariante;
        this.idProducto = idProducto;
        this.tamanoVariante = tamanoVariante;
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

    public String getTamanoVariante() {
        return tamanoVariante;
    }

    public void setTamanoVariante(String tamanoVariante) {
        this.tamanoVariante = tamanoVariante;
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
