package com.gestion.personal.services.implement;

import com.gestion.personal.domain.entity.Persona;
import com.gestion.personal.domain.repository.PersonaRepository;
import com.gestion.personal.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }
}
