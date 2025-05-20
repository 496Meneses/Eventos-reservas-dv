package com.gestion.personal.controller;

import com.gestion.personal.domain.entity.Rol;
import com.gestion.personal.services.CatalogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Catalogo Controller" , description = "Servicio para obtener los catalogos")
@RestController
@RequestMapping("/api/catalogos")
public class CatalogoController {
	@Autowired
	private CatalogoService catalogoService;

	@Operation(summary = "Listar catalogo roles")
	@GetMapping("/roles")
	public List<Rol> listarCatalogoRoles() {
		return this.catalogoService.listarRoles();
	}

}
