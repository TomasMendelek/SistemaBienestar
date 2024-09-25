package com.backend.bienestar.repositories;

import com.backend.bienestar.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
