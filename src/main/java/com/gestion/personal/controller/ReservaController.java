package com.gestion.personal.controller;

import com.gestion.personal.domain.dto.EventoReservaDTO;
import com.gestion.personal.domain.entity.Reserva;

import com.gestion.personal.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private  ReservaService reservaService;


    @PostMapping
    public Reserva crearReserva(@RequestParam Long eventoId, @RequestParam Long personaId) {
        return reservaService.crearReserva(eventoId, personaId);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Reserva obtenerPorId(@PathVariable Long id) {
        return reservaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
    }

    @GetMapping("/persona/{personaId}")
    public List<EventoReservaDTO> obtenerPorPersona(@PathVariable Long personaId) {
        return reservaService.obtenerEventosPorPersona(personaId);
    }
}

