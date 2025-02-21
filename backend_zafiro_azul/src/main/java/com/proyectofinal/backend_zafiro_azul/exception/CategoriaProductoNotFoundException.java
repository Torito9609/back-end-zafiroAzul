package com.proyectofinal.backend_zafiro_azul.exception;

public class CategoriaProductoNotFoundException extends RuntimeException {
    public CategoriaProductoNotFoundException(Long id_categoria) {
        super("La categoría con ID " + id_categoria + " no existe.");
    }
}
