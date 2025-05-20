package com.gestion.personal.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "correo")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_personabigint", referencedColumnName = "id")
    private Persona persona;

    // Getters y Setters
}