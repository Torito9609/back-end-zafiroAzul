package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;

@Getter
public class EntityConflictException extends RuntimeException{
    private String entityName;
    private String fieldName;
    private String fieldValue;
    public EntityConflictException(String entityName, String fieldName, String fieldValue) {
        super("Ya existe una " + entityName + " con " + fieldName + " '" + fieldValue + "'. Por favor elija otro " + fieldName + ".");
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
