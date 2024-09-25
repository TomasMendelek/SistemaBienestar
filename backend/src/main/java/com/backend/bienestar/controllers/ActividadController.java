package com.backend.bienestar.controllers;

import com.backend.bienestar.models.Actividad;
import com.backend.bienestar.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<Actividad> obtenerActividades() {
        return actividadService.obtenerTodasLasActividades();
    }

    @GetMapping("/{id}")
    public Optional<Actividad> obtenerActividadPorId(@PathVariable String id) {
        return actividadService.obtenerActividadPorId(id);
    }

    @PostMapping
    public Actividad crearActividad(@RequestBody Actividad actividad) {
        return actividadService.crearActividad(actividad);
    }

    @DeleteMapping("/{id}")
    public void eliminarActividad(@PathVariable String id) {
        actividadService.eliminarActividad(id);
    }
}
