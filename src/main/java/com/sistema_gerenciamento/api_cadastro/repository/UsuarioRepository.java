package com.sistema_gerenciamento.api_cadastro.repository;

import com.sistema_gerenciamento.api_cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}