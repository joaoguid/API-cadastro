package com.sistema_gerenciamento.api_cadastro.controller;

import com.sistema_gerenciamento.api_cadastro.model.Usuario;
import com.sistema_gerenciamento.api_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario criar(@RequestBody @Valid Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

}
