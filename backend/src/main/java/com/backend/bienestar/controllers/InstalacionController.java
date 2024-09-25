package com.backend.bienestar.controllers;

import com.backend.bienestar.models.Instalacion;
import com.backend.bienestar.services.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionService instalacionService;

    @GetMapping
    public List<Instalacion> obtenerInstalaciones() {
        return instalacionService.obtenerTodasLasInstalaciones();
    }

    @GetMapping("/{id}")
    public Optional<Instalacion> obtenerInstalacionPorId(@PathVariable String id) {
        return instalacionService.obtenerInstalacionPorId(id);
    }

    @PostMapping
    public Instalacion crearInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionService.crearInstalacion(instalacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarInstalacion(@PathVariable String id) {
        instalacionService.eliminarInstalacion(id);
    }
}
