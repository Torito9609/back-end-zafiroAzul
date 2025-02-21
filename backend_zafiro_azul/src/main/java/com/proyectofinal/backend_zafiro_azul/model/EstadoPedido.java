package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @NotBlank(message = "El nombre de estado no puede ser vacío")
    @Size(max = 50, message = "El nombre de un estado no puede tener más de 50 caracteres.")
    @Column(nullable = false)
    private String nombreEstado;

    @OneToMany(mappedBy = "estadoPedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidos;

    public EstadoPedido(Long idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public EstadoPedido() {
    }

}
