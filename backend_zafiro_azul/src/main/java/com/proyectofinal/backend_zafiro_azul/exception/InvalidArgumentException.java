package com.proyectofinal.backend_zafiro_azul.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String entityName, String fieldName) {
        super(fieldName + " de " + entityName + " no puede estar vacío o nulo.");
    }
}
