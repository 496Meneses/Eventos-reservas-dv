package com.gestion.personal.mapper;

import com.gestion.personal.domain.dto.UsuarioDTO;
import com.gestion.personal.domain.entity.Rol;
import com.gestion.personal.domain.entity.Usuario;


public class UsuarioMapper {
	private UsuarioMapper() throws Exception { throw  new Exception(); }
	public static Usuario mapearEntidad(UsuarioDTO dto) {
		Rol rol = new Rol();
		if (dto.getIdRol() != null) {
			rol.setId(dto.getIdRol());
		}
		return Usuario.builder()
				.id(dto.getId())
				.correo(dto.getCorreo())
				.rol(dto.getIdRol() != null ? rol : null)
				.build();
	}
	public static UsuarioDTO mapearDTO(Usuario entidad) {
		return UsuarioDTO.builder()
				.correo(entidad.getCorreo())
				.id(entidad.getId())
				.idRol(entidad.getRol() != null ? entidad.getRol().getId() : null)
				.desRol(entidad.getRol() != null ? entidad.getRol().getDescripcion() : null)
				.build();
	}
}
