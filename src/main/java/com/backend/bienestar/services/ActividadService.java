package com.backend.bienestar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.bienestar.models.Actividad;
import com.backend.bienestar.repositories.ActividadRepository;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> obtenerTodasLasActividades(){
        return actividadRepository.findAll();
    }
    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }
    public Optional<Actividad> obtenerActividadPorId(String id) {
        return actividadRepository.findById(id);
    }
    public void eliminarActividad(String id) {
        actividadRepository.deleteById(id);
    }




}
