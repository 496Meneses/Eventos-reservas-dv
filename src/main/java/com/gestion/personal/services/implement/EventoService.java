package com.gestion.personal.services.implement;

import com.gestion.personal.constantes.Mensajes;
import com.gestion.personal.domain.dto.MensajeDTO;
import com.gestion.personal.domain.dto.request.RequestEventoDTO;
import com.gestion.personal.domain.entity.Evento;
import com.gestion.personal.domain.repository.EventoRepository;
import com.gestion.personal.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class EventoService implements IEventoService {

    @Autowired
    private EventoRepository eventoRepository;


    public LocalDate convertirStringALocalDate(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    @Override
    public MensajeDTO crear(RequestEventoDTO eventoDTO) {
        this.eventoRepository.save(Evento.builder()
                        .fecha(this.convertirStringALocalDate(eventoDTO.getFechaEvento()))
                .build());
        return MensajeDTO.builder()
                .error(false)
                .respuesta(Mensajes.EVENTO_CREADO)
                .build();
    }
}
