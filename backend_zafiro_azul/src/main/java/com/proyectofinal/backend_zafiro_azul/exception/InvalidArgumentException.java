package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;

@Getter
public class InvalidArgumentException extends RuntimeException {
    private String entityName;
    private String fieldName;
    public InvalidArgumentException(String entityName, String fieldName) {
        super(fieldName + " de " + entityName + " no puede estar vacío o nulo.");
        this.entityName = entityName;
        this.fieldName = fieldName;
    }
}
