package com.backend.bienestar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.bienestar.models.Actividad;

public interface ActividadRepository extends MongoRepository<Actividad, String>{

    
}