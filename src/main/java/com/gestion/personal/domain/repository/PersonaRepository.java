package com.gestion.personal.domain.repository;

import com.gestion.personal.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}