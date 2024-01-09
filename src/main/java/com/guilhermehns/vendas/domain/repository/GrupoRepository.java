package com.guilhermehns.vendas.domain.repository;

import com.guilhermehns.vendas.domain.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    Optional<Grupo> findByNome(String nome);

}
