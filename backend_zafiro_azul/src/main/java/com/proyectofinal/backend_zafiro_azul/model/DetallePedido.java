package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Var;

import java.math.BigDecimal;
@Setter
@Getter
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    @JsonIgnore
    @NotBlank(message = "Detalle pedido debe estar asociado a un pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idVariante", nullable = false)
    private VarianteProducto varianteProducto;

    @Column(nullable = false)
    @NotBlank(message = "La cantidad de variante no puede estar vacía")
    @Min(value = 1, message = "La cantidad de vairante debe ser al menos 1")
    private Integer cantidadVariante;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotBlank(message = "El precio unitario no puede estar vacío")
    @DecimalMin(value = "0.00", message = "El precio unitario no puede ser negativo")
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotBlank(message = "El subtotal no puede estar vacío")
    @DecimalMin(value = "0.00", message = "El subtotal no puede ser negativo")
    private BigDecimal subTotal;

    public DetallePedido(Long idDetalle, Pedido pedido, VarianteProducto varianteProducto, Integer cantidadVariante, BigDecimal precioUnitario, BigDecimal subTotal) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.varianteProducto = varianteProducto;
        this.cantidadVariante = cantidadVariante;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public DetallePedido() {}

    public VarianteProducto getVariante() {
        return varianteProducto;
    }

    public void setVariante(VarianteProducto varianteProducto) {
        this.varianteProducto = varianteProducto;
    }

}
