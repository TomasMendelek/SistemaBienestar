package com.backend.bienestar.controllers;

import com.backend.bienestar.models.Suscripcion;
import com.backend.bienestar.services.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @GetMapping
    public List<Suscripcion> obtenerSuscripciones() {
        return suscripcionService.obtenerTodasLasSuscripciones();
    }

    @GetMapping("/{id}")
    public Optional<Suscripcion> obtenerSuscripcionPorId(@PathVariable String id) {
        return suscripcionService.obtenerSuscripcionPorId(id);
    }

    @PostMapping
    public Suscripcion crearSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.crearSuscripcion(suscripcion);
    }

    @DeleteMapping("/{id}")
    public void eliminarSuscripcion(@PathVariable String id) {
        suscripcionService.eliminarSuscripcion(id);
    }
}
