package com.guilhermehns.vendas.domain.repository;

import com.guilhermehns.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
