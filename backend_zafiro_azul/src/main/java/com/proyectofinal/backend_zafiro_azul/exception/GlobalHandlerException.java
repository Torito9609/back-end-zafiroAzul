package com.proyectofinal.backend_zafiro_azul.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalHandlerException{

    @ExceptionHandler(CategoriaProductoNotFoundException.class)
    public ResponseEntity<?> handleCategoriaProductoNotFoundException(CategoriaProductoNotFoundException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityConflictException.class)
    public ResponseEntity<?> handleEntityConflictException(EntityConflictException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleIllegalArgumentException(InvalidArgumentException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DetallePedidoNotFoundException.class)
    public ResponseEntity<?> handleDetallePedidoNotFoundException(DetallePedidoNotFoundException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
