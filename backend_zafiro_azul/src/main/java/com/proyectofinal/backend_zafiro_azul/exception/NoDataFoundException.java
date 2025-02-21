package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;

@Getter
public class NoDataFoundException extends RuntimeException {
    private String entityName;

    public NoDataFoundException(String entityName) {
        super("No se encontraron " + entityName);
        this.entityName = entityName;
    }
}
