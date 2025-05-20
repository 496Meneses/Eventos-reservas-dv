package com.gestion.personal.domain.repository;

import com.gestion.personal.domain.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findByPersonaId(Long id);
}