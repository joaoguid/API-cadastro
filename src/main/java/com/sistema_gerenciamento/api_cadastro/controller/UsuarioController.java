package com.sistema_gerenciamento.api_cadastro.controller;

import com.sistema_gerenciamento.api_cadastro.model.Usuario;
import com.sistema_gerenciamento.api_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        System.out.println("REQUISIÇÃO RECEBIDA!");
        return usuarioRepository.save(usuario);
    }
}
