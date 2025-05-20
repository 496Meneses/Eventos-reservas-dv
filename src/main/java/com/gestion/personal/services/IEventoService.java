package com.gestion.personal.services;

import com.gestion.personal.domain.dto.MensajeDTO;
import com.gestion.personal.domain.dto.request.RequestEventoDTO;


public interface IEventoService {
    MensajeDTO crear(RequestEventoDTO eventoDTO);
}
