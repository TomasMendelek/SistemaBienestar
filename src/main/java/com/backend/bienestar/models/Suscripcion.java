package com.backend.bienestar.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "Suscripciones")
public class Suscripcion {
    @Id
    private String miembroId;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechafin;
    private String estado;
}
