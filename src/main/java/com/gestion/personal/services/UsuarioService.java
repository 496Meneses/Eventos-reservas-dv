package com.gestion.personal.services;

import com.gestion.personal.domain.dto.UsuarioDTO;


import java.util.List;

public interface UsuarioService {
	UsuarioDTO obtenerDetallePorCorreo(String correo);
	UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
	List<UsuarioDTO> listarUsuarios();

	Boolean eliminarUsuario(Long id);
}
