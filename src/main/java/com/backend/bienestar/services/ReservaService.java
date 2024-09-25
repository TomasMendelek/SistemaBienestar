package com.backend.bienestar.services;

import com.backend.bienestar.models.Reserva;
import com.backend.bienestar.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> obtenerReservaPorId(String id) {
        return reservaRepository.findById(id);
    }

    public void eliminarReserva(String id) {
        reservaRepository.deleteById(id);
    }
}
