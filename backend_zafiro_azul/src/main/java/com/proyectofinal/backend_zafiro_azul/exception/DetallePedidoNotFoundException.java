package com.proyectofinal.backend_zafiro_azul.exception;

public class DetallePedidoNotFoundException extends RuntimeException {
    public DetallePedidoNotFoundException(Long idDetalle) {
        super("El detalle pedido con id " + idDetalle + " no existe.");
    }
}
