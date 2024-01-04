package com.guilhermehns.vendas.service;

import com.guilhermehns.vendas.domain.entity.Pedido;
import com.guilhermehns.vendas.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
}
