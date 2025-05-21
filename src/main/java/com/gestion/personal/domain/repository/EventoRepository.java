package com.gestion.personal.domain.repository;

import com.gestion.personal.domain.entity.Evento;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findByFecha(Date fecha);
    @Query("SELECT r.evento FROM Reserva r WHERE r.personaId = :personaId")
    List<Evento> findEventosReservadosPorPersona(@Param("personaId") Long personaId);
}