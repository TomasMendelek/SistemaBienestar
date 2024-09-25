package com.backend.bienestar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.bienestar.models.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    
}