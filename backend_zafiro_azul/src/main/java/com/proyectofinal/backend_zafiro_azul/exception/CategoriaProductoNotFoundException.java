package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;

@Getter
public class CategoriaProductoNotFoundException extends RuntimeException {
    private Long idCategoria;  // Puedes incluir detalles adicionales si quieres

    public CategoriaProductoNotFoundException(Long idCategoria) {
        super("No se encontró la categoría de producto con ID: " + idCategoria);
        this.idCategoria = idCategoria;
    }

}
