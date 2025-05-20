package com.gestion.personal.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "fecha")
    private LocalDate fecha;

}