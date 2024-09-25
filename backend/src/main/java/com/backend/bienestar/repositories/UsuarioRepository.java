package com.backend.bienestar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.bienestar.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
