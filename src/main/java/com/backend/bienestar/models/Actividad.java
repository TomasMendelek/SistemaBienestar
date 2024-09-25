package com.backend.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "actividades")
public class Actividad {
    @Id
    private String id;
    private String Nombre;
    private String Descripcion;
    private int Duracion;
    private String instructorId;
    private String tipoActividad;
}


