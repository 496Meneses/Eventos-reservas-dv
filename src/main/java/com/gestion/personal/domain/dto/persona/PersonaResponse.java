package com.gestion.personal.domain.dto.persona;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonaResponse {
	private Long id;
	private String nombres;
	private String apellidos;
}
