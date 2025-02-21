package com.proyectofinal.backend_zafiro_azul.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String entityName) {
        super("No se encontraron " + entityName);
    }
}
