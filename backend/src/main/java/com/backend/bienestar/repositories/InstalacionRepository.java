package com.backend.bienestar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.bienestar.models.Instalacion;

public interface InstalacionRepository extends MongoRepository<Instalacion, String>{

    
}