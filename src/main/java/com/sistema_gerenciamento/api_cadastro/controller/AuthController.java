package com.sistema_gerenciamento.api_cadastro.controller;

import com.sistema_gerenciamento.api_cadastro.dto.UsuarioLoginDTO;
import com.sistema_gerenciamento.api_cadastro.model.Usuario;
import com.sistema_gerenciamento.api_cadastro.repository.UsuarioRepository;
import com.sistema_gerenciamento.api_cadastro.Security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuario == null || !passwordEncoder.matches(loginDTO.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        String token = jwtUtil.generateToken(usuario.getEmail());

        return ResponseEntity.ok().body("Bearer " + token);
    }
}
