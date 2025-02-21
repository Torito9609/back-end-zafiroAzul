package com.proyectofinal.backend_zafiro_azul.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Pedido {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Setter
    @ManyToOne
    @JoinColumn(name= "idUsuario")
    @JsonIgnore
    private Usuario usuario;

    @Setter
    @ManyToOne
    @JoinColumn(name = "idUsuarioTemp")
    @JsonIgnore
    private UsuarioTemporal usuarioTemp;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idEstadoPedido", nullable = false)
    @JsonIgnore
    private EstadoPedido estadoPedido;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "La fecha no puede estar vacía.")
    @PastOrPresent(message = "La fecha no puede futura.")
    @Column(nullable = false)
    private Date fechaPedido;

    @Setter
    @DecimalMin(value = "0.01", message = "El total del pedido debe ser mayor a cero.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPedido;

    @Setter
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(message = "Un pedido debe tener al menos un detalle de pedido.")
    @Valid
    private List<DetallePedido> detallesPedido;

    public Pedido(Date fechaPedido, Usuario usuario, EstadoPedido estadoPedido, BigDecimal totalPedido) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario registrado no puede ser nulo.");
        }
        this.fechaPedido = fechaPedido;
        this.usuario = usuario;
        this.estadoPedido = estadoPedido;
        this.totalPedido = totalPedido;
        this.usuarioTemp = null; // Asegurar que usuario temporal no se usa
    }

    public Pedido(Date fechaPedido, UsuarioTemporal usuarioTemp, EstadoPedido estadoPedido, BigDecimal totalPedido) {
        if (usuarioTemp == null) {
            throw new IllegalArgumentException("El usuario temporal no puede ser nulo.");
        }
        this.fechaPedido = fechaPedido;
        this.usuarioTemp = usuarioTemp;
        this.estadoPedido = estadoPedido;
        this.totalPedido = totalPedido;
        this.usuario = null; // Asegurar que usuario registrado no se usa
    }

    public Pedido() {
    }

    @PrePersist
    @PreUpdate
    private void validarUsuario() {
        if (usuario != null && usuarioTemp != null) {
            throw new IllegalArgumentException("El pedido no puede tener un usuario registrado y un usuario temporal al mismo tiempo.");
        }
        if (usuario == null && usuarioTemp == null) {
            throw new IllegalArgumentException("El pedido debe tener un usuario registrado o un usuario temporal.");
        }
    }
}
