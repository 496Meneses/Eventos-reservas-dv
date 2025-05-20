package com.gestion.personal.services;

import com.gestion.personal.domain.entity.Persona;

import java.util.Optional;

public interface IPersonaService {
    Optional<Persona> findById(Long id);
}
