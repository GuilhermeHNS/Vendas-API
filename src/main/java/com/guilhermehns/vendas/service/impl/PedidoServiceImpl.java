package com.guilhermehns.vendas.service.impl;

import com.guilhermehns.vendas.domain.repository.Pedidos;
import com.guilhermehns.vendas.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
