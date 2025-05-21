package com.gestion.personal.controller;

import com.gestion.personal.domain.dto.JwtResponseDTO;
import com.gestion.personal.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestParam String correo, @RequestParam String password) {
        String jwt = authService.autenticar(correo, password);
        JwtResponseDTO response = new JwtResponseDTO(jwt);
        return ResponseEntity.ok(response);
    }
}

