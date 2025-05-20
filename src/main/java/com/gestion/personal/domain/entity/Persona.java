package com.gestion.personal.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persona")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    private Long id;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;

    // Getters y Setters
}