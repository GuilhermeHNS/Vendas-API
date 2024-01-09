package com.guilhermehns.vendas.rest.controller;

import com.guilhermehns.vendas.domain.entity.Usuario;
import com.guilhermehns.vendas.rest.dto.CadastroUsuarioDTO;
import com.guilhermehns.vendas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario save(@RequestBody CadastroUsuarioDTO dto){
        return service.save(dto);
    }

}
