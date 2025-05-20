package com.gestion.personal.controller;

import com.gestion.personal.domain.dto.MensajeDTO;
import com.gestion.personal.domain.dto.request.RequestEventoDTO;
import com.gestion.personal.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @PostMapping("crear")
    public MensajeDTO crearEvento(@RequestBody RequestEventoDTO eventoDTO) {
        return this.eventoService.crear(eventoDTO);
    }
}