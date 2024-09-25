package com.backend.bienestar.controllers;

import com.backend.bienestar.models.Reserva;
import com.backend.bienestar.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservaService.obtenerTodasLasReservas();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> obtenerReservaPorId(@PathVariable String id) {
        return reservaService.obtenerReservaPorId(id);
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable String id) {
        reservaService.eliminarReserva(id);
    }
}
