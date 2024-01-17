package com.guilhermehns.vendas.service;

import com.guilhermehns.vendas.domain.entity.Usuario;
import com.guilhermehns.vendas.rest.dto.CadastroUsuarioDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioService {

    public Usuario save(CadastroUsuarioDTO dto);

    public UserDetails loadUserByUserName(String username);

    public UserDetails autenticar(Usuario usuario);
}
