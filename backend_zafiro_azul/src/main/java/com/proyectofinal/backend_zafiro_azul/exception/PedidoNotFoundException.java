package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;

@Getter
public class PedidoNotFoundException extends RuntimeException {
    private final Long idPedido;
    public PedidoNotFoundException(Long idPedido) {
        super("El pedido con id " + idPedido + " no existe.");
        this.idPedido = idPedido;
    }
}
