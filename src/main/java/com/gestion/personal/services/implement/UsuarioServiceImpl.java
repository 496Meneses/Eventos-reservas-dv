package com.gestion.personal.services.implement;

import com.gestion.personal.domain.dto.UsuarioDTO;
import com.gestion.personal.domain.entity.Usuario;
import com.gestion.personal.domain.repository.UsuarioRepository;
import com.gestion.personal.mapper.UsuarioMapper;
import com.gestion.personal.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioDTO obtenerDetallePorCorreo(String correo) {
		Usuario usuario = usuarioRepository.findByCorreo(correo).get();
        return UsuarioMapper.mapearDTO(usuario);
    }

	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario resultado = this.usuarioRepository.save(UsuarioMapper.mapearEntidad(usuarioDTO));
        return UsuarioMapper.mapearDTO(resultado);
    }

	@Override
	public List<UsuarioDTO> listarUsuarios() {
		return this.usuarioRepository.findAll().stream().map(UsuarioMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean eliminarUsuario(Long id) {
		this.usuarioRepository.deleteById(id);
		return true;
	}
}
