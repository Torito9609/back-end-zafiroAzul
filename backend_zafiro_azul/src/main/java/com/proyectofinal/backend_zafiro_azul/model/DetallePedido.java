package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Var;

import java.math.BigDecimal;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idVariante", nullable = false)
    private VarianteProducto varianteProducto;

    @Column(nullable = false)
    private Integer cantidadVariante;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotal;

    public DetallePedido(Long idDetalle, Pedido pedido, VarianteProducto varianteProducto, Integer cantidadVariante, BigDecimal precioUnitario, BigDecimal subTotal) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.varianteProducto = varianteProducto;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public VarianteProducto getVariante() {
        return varianteProducto;
    }

    public void setVariante(VarianteProducto varianteProducto) {
        this.varianteProducto = varianteProducto;
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
