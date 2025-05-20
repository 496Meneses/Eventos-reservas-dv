package com.gestion.personal.domain.repository;

import com.gestion.personal.domain.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRolRepository extends JpaRepository<Rol, Long> {
}
