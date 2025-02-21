package com.proyectofinal.backend_zafiro_azul.exception;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class MonetaryCalculationException extends RuntimeException {
    private final String tipoCalculo;
    private final String entidad;
    private final BigDecimal valorEsperado;
    public MonetaryCalculationException(String tipoCalculo, String entidad, BigDecimal valorEsperado) {
        super(String.format("Error en el cálculo de %s en la entidad %s. Valor esperado: %s",
                tipoCalculo, entidad, valorEsperado));
        this.tipoCalculo = tipoCalculo;
        this.entidad = entidad;
        this.valorEsperado = valorEsperado;
    }
}
