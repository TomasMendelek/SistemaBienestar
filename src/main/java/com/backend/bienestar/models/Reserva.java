package com.backend.bienestar.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "reservas")
public class Reserva {
    @Id
    private String id;
    private String miembroId;
    private String actividadId;
    private LocalDateTime fechaHora;
    private String estado;
}
