package com.guilhermehns.vendas.rest.dto;

import com.guilhermehns.vendas.domain.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CadastroUsuarioDTO {

    private Usuario usuario;

    private List<String> permissoes;
}
