package com.backend.bienestar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.bienestar.models.Suscripcion;

public interface SuscripcionRepository extends MongoRepository<Suscripcion, String>{
    
}
