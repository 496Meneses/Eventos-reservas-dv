package com.gestion.personal.services.implement;

import com.gestion.personal.domain.entity.Rol;
import com.gestion.personal.domain.repository.CatRolRepository;
import com.gestion.personal.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {
	@Autowired
	private CatRolRepository rolRepository;

	@Override
	public List<Rol> listarRoles() {
		return this.rolRepository.findAll();
	}

}
