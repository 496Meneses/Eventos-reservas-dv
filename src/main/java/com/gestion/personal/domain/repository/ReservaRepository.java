package com.gestion.personal.domain.repository;

import com.gestion.personal.domain.entity.Reserva;
import com.gestion.personal.domain.entity.Evento;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    long countByEvento(Evento evento);
    Reserva findByEventoAndPersonaId(Evento evento, Long idPersona);
    List<Reserva> findByPersonaId(Long personaId);

}

