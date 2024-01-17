package com.guilhermehns.vendas.rest.controller;

import com.guilhermehns.vendas.domain.entity.Usuario;
import com.guilhermehns.vendas.exception.SenhaInvalidaException;
import com.guilhermehns.vendas.rest.dto.CadastroUsuarioDTO;
import com.guilhermehns.vendas.rest.dto.CredenciaisDTO;
import com.guilhermehns.vendas.rest.dto.TokenDTO;
import com.guilhermehns.vendas.security.jwt.JwtService;
import com.guilhermehns.vendas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final JwtService jwtService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario save(@RequestBody CadastroUsuarioDTO dto){
        return service.save(dto);
    }


    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciaisDTO){
        try{
            Usuario usuario = Usuario
                    .builder()
                            .login(credenciaisDTO.getLogin())
                                    .senha(credenciaisDTO.getSenha())
                                            .build();

            UserDetails usuarioAutenticado = service.autenticar(usuario);

            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getLogin(), token);

        }catch (UsernameNotFoundException  | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
        }
    }
}
