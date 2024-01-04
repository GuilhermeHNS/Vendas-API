package com.guilhermehns.vendas.rest.controller;

import com.guilhermehns.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

    private PedidoService service;
    public PedidoController(PedidoService service) {
        this.service = service;
    }


}
