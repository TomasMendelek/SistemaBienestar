package com.backend.bienestar.services;

import com.backend.bienestar.models.Actividad;
import com.backend.bienestar.models.Reserva;
import com.backend.bienestar.models.Usuario;
import com.backend.bienestar.repositories.ActividadRepository;
import com.backend.bienestar.repositories.ReservaRepository;
import com.backend.bienestar.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    public List<Actividad> generarRecomendaciones(String usuarioId) {
        //Obtener el usuario por su ID
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) {
            return List.of();
        }
        Usuario usuario = usuarioOpt.get();

        //Obtener las reservas pasadas del usuario
        List<Reserva> reservasUsuario = reservaRepository.findAll().stream()
                .filter(reserva -> reserva.getMiembroId().equals(usuarioId))
                .collect(Collectors.toList());

        //Obtener todas las actividades
        List<Actividad> todasLasActividades = actividadRepository.findAll();

        //Filtrar actividades que coincidan con los objetivos del usuario
        return todasLasActividades.stream()
                .filter(actividad -> actividad.getTipoActividad().toLowerCase()
                        .contains(usuario.getObjetivos().toLowerCase()))
                .filter(actividad -> reservasUsuario.stream()
                        .noneMatch(reserva -> reserva.getActividadId().equals(actividad.getId())))
                .collect(Collectors.toList());
    }
}
