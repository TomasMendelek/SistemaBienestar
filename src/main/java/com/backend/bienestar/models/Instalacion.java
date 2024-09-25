package com.backend.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "instalaciones")
public class Instalacion {
    @Id
    private String id;
    private String nombre;
    private int capacidad;
    private String equiposDisponibles;
    
}