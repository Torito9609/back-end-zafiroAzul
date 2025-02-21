package com.proyectofinal.backend_zafiro_azul.exception;

public class EntityConflictException extends RuntimeException{
    public EntityConflictException(String entityName, String fieldName, String fieldValue) {
        super("Ya existe una " + entityName + " con " + fieldName + " '" + fieldValue + "'. Por favor elija otro " + fieldName + ".");
    }
}
