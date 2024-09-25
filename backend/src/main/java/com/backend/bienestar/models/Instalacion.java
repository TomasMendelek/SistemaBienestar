package com.backend.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instalaciones")
public class Instalacion {
    @Id
    private String id;
    private String nombre;
    private int capacidad;
    private String equiposDisponibles;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEquiposDisponibles() {
        return equiposDisponibles;
    }

    public void setEquiposDisponibles(String equiposDisponibles) {
        this.equiposDisponibles = equiposDisponibles;
    }
}
