package com.gestion.personal.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UsuarioDTO implements Serializable {
	private Long id;
	private String nombre;
	private String correo;
	private Long idPrograma;
	private Long idRol;
	private String desPrograma;
	private String password;
	private String desRol;
}
