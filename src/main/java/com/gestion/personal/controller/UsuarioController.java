package com.gestion.personal.controller;

import com.gestion.personal.domain.dto.UsuarioDTO;
import com.gestion.personal.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Usuario Controller" , description = "Servicios para los usuarios")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Operation(summary = "Consultar detallde de usuario por correo")

    @GetMapping("/detalle/{correo}")
    public UsuarioDTO detalleUsuarioPorCorreo(@PathVariable String correo) {
        return this.usuarioService.obtenerDetallePorCorreo(correo);
    }

    @Operation(summary = "Crear usuario")
    @PostMapping("/crear")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO dto) {
        return this.usuarioService.crearUsuario(dto);
    }

    @Operation(summary = "Listar usuarios")
    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios() {
        return this.usuarioService.listarUsuarios();
    }

    @Operation(summary = "Eliminar usuario")
    @PostMapping("/eliminar/{id}")
    public Boolean eliminarUsuario(@PathVariable Long id) {
        return this.usuarioService.eliminarUsuario(id);
    }

}
