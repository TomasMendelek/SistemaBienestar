package com.backend.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String tipo;
    private String objetivos;
    private String progreso;
}
