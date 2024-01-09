package com.guilhermehns.vendas.domain.repository;

import com.guilhermehns.vendas.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
