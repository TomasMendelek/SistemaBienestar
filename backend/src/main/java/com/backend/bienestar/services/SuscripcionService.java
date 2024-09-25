package com.backend.bienestar.services;

import com.backend.bienestar.models.Suscripcion;
import com.backend.bienestar.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public List<Suscripcion> obtenerTodasLasSuscripciones() {
        return suscripcionRepository.findAll();
    }

    public Suscripcion crearSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Optional<Suscripcion> obtenerSuscripcionPorId(String id) {
        return suscripcionRepository.findById(id);
    }

    public void eliminarSuscripcion(String id) {
        suscripcionRepository.deleteById(id);
    }
}
