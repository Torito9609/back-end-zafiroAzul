package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;

@Getter
public class EstadoPedidoNotFoundException extends RuntimeException {
    private final Long idEstado;
    public EstadoPedidoNotFoundException(Long idEstado) {
        super("El detalle pedido con id " + idEstado + " no existe.");
        this.idEstado = idEstado;
      }
}

