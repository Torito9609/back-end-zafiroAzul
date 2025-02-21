package com.proyectofinal.backend_zafiro_azul.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name= "idUsuario")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idUsuarioTemp")
    @JsonIgnore
    private UsuarioTemporal usuarioTemp;

    @ManyToOne
    @JoinColumn(name = "idEstadoPedido", nullable = false)
    @JsonIgnore
    private EstadoPedido estadoPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaPedido;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioTemporal getUsuarioTemp() {
        return usuarioTemp;
    }

    public void setUsuarioTemp(UsuarioTemporal usuarioTemp) {
        this.usuarioTemp = usuarioTemp;
    }

    public EstadoPedido getEstadoPedido(){return estadoPedido;}

    private void setEstadoPedido(EstadoPedido estadoPedido){this.estadoPedido = estadoPedido;}

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
}
