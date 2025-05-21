package com.gestion.personal.services;

import com.gestion.personal.domain.dto.EventoReservaDTO;
import com.gestion.personal.domain.entity.Reserva;

import java.util.List;

public interface ReservaService {
    Reserva crearReserva(Long eventoId, Long personaId);
    List<Reserva> obtenerTodas();
    Reserva obtenerPorId(Long id);
    void eliminar(Long id);
    List<EventoReservaDTO> obtenerEventosPorPersona(Long personaId);
}
