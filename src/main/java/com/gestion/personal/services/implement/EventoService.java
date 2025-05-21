package com.gestion.personal.services.implement;

import com.gestion.personal.constantes.Mensajes;
import com.gestion.personal.domain.dto.MensajeDTO;
import com.gestion.personal.domain.dto.request.RequestEventoDTO;
import com.gestion.personal.domain.dto.response.ResponseEventoDTO;
import com.gestion.personal.domain.entity.Evento;
import com.gestion.personal.domain.entity.Reserva;
import com.gestion.personal.domain.repository.EventoRepository;
import com.gestion.personal.domain.repository.ReservaRepository;
import com.gestion.personal.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoService implements IEventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private  ReservaRepository reservaRepository;

    public Date convertirStringADate(String fechaStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(fechaStr);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public MensajeDTO crear(RequestEventoDTO eventoDTO) {
        if (this.eventoEsValidoParaCrear(eventoDTO)) {
            this.eventoRepository.save(Evento.builder()
                    .fecha(this.convertirStringADate(eventoDTO.getDate()))
                    .titulo(eventoDTO.getTitle())
                    .descripcion(eventoDTO.getExtendedProps().getDescripcion())
                    .id(eventoDTO.getId())
                            .limite(eventoDTO.getLimite())
                    .build());
            return MensajeDTO.builder()
                    .error(false)
                    .respuesta(Mensajes.EVENTO_CREADO)
                    .build();
        } else {
            return MensajeDTO.builder()
                    .error(true)
                    .respuesta(Mensajes.EVENTO_ERROR_FECHA_EXISTENTE)
                    .build();
        }
    }

    private Boolean eventoEsValidoParaCrear(RequestEventoDTO eventoDTO) {
        Evento evento = this.eventoRepository.findByFecha(this.convertirStringADate(eventoDTO.getDate()));
        return evento == null || (eventoDTO.getId() != null && Objects.equals(evento.getId(), eventoDTO.getId()));
    }

    @Override
    public List<ResponseEventoDTO> listarEventos() {
        return this.eventoRepository.findAll().stream().map(this::mapearEvento).toList();
    }

    @Override
    public MensajeDTO eliminarEvento(Long id) {
        Optional<Evento> evento = this.eventoRepository.findById(id);
        if (evento.isEmpty()) {
            return MensajeDTO.builder()
                    .error(true)
                    .respuesta(Mensajes.EVENTO_NO_EXISTE)
                    .build();
        }
        this.eventoRepository.delete(evento.get());
        return MensajeDTO.builder()
                .error(false)
                .respuesta(Mensajes.EVENTO_ELIMINADO)
                .build();
    }

    public ResponseEventoDTO mapearEvento(Evento evento) {
        return ResponseEventoDTO.builder()
                .date(evento.getFecha())
                .extendedProps(ResponseEventoDTO.ExtendedProps.builder().descripcion(evento.getDescripcion()).build())
                .title(evento.getTitulo())
                .limite(evento.getLimite())
                .id(evento.getId())
                .build();
    }

    public List<ResponseEventoDTO> obtenerEventosDisponibles(Long idPersona) {
        return eventoRepository.findAll().stream()
                .filter(evento -> {
                    long reservas = reservaRepository.countByEvento(evento);
                    Reserva reserva = reservaRepository.findByEventoAndPersonaId(evento, idPersona);
                    return (evento.getLimite() == null || reservas < evento.getLimite()) && reserva == null;
                })
                .toList().stream().map(this::mapearEvento).toList();
    }
}
