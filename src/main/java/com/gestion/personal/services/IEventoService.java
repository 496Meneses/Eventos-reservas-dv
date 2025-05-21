package com.gestion.personal.services;

import com.gestion.personal.domain.dto.MensajeDTO;
import com.gestion.personal.domain.dto.request.RequestEventoDTO;
import com.gestion.personal.domain.dto.response.ResponseEventoDTO;

import java.util.List;


public interface IEventoService {
    MensajeDTO crear(RequestEventoDTO eventoDTO);

    List<ResponseEventoDTO> listarEventos();

    MensajeDTO eliminarEvento(Long id);

    List<ResponseEventoDTO> obtenerEventosDisponibles(Long idPersona);
}
