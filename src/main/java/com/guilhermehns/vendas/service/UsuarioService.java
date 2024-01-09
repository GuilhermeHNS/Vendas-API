package com.guilhermehns.vendas.service;

import com.guilhermehns.vendas.domain.entity.Usuario;
import com.guilhermehns.vendas.rest.dto.CadastroUsuarioDTO;

public interface UsuarioService {

    public Usuario save(CadastroUsuarioDTO dto);
}
