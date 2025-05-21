package com.gestion.personal.service;

import com.gestion.personal.domain.dto.EventoReservaDTO;
import com.gestion.personal.domain.dto.response.ResponseEventoDTO;
import com.gestion.personal.domain.entity.Evento;
import com.gestion.personal.domain.entity.Reserva;
import com.gestion.personal.domain.repository.EventoRepository;
import com.gestion.personal.domain.repository.ReservaRepository;
import com.gestion.personal.services.ReservaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private  ReservaRepository reservaRepository;
    @Autowired
    private  EventoRepository eventoRepository;

    @Override
    public Reserva crearReserva(Long eventoId, Long personaId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));

        long totalReservas = reservaRepository.countByEvento(evento);

        if (evento.getLimite() != null && totalReservas >= evento.getLimite()) {
            throw new IllegalStateException("Límite de reservas alcanzado");
        }

        Reserva reserva = Reserva.builder()
                .personaId(personaId)
                .evento(evento)
                .build();

        return reservaRepository.save(reserva);
    }
    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }
    @Override
    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada"));
    }
    @Override
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public List<EventoReservaDTO> obtenerEventosPorPersona(Long personaId) {
        List<Reserva> reservas = reservaRepository.findByPersonaId(personaId);
        return reservas.stream().map(reserva -> {
            Evento evento = reserva.getEvento();
            ResponseEventoDTO eventoDTO = ResponseEventoDTO.builder()
                    .id(evento.getId())
                    .title(evento.getTitulo())
                    .date(evento.getFecha())
                    .limite(evento.getLimite())
                    .extendedProps(
                            ResponseEventoDTO.ExtendedProps.builder()
                                    .descripcion(evento.getDescripcion())
                                    .build()
                    )
                    .build();

            return EventoReservaDTO.builder()
                    .idReserva(reserva.getId())
                    .idPersona(reserva.getPersonaId())
                    .evento(eventoDTO)
                    .build();
        }).toList();
    }
}
