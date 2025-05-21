package com.gestion.personal.controller;

import com.gestion.personal.domain.dto.MensajeDTO;
import com.gestion.personal.domain.dto.request.RequestEventoDTO;
import com.gestion.personal.domain.dto.response.ResponseEventoDTO;
import com.gestion.personal.services.IEventoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @PostMapping("crear")
    public MensajeDTO crearEvento(@RequestBody RequestEventoDTO eventoDTO) {
        return this.eventoService.crear(eventoDTO);
    }

    @GetMapping("listar")
    public List<ResponseEventoDTO> listarEventos() {
        return this.eventoService.listarEventos();
    }

    @Operation(summary = "Eliminar evento")
    @PostMapping("/eliminar/{id}")
    public MensajeDTO eliminarEvento(@PathVariable Long id) {
        return this.eventoService.eliminarEvento(id);
    }

    @GetMapping("listarDisponibles/{idPersona}")
    public List<ResponseEventoDTO> listarEventosDisponibles(@PathVariable Long idPersona) {
        return this.eventoService.obtenerEventosDisponibles(idPersona);
    }

}