package com.guilhermehns.vendas.service.impl;

import com.guilhermehns.vendas.domain.entity.Grupo;
import com.guilhermehns.vendas.domain.entity.Usuario;
import com.guilhermehns.vendas.domain.entity.UsuarioGrupo;
import com.guilhermehns.vendas.domain.repository.GrupoRepository;
import com.guilhermehns.vendas.domain.repository.UsuarioGrupoRepository;
import com.guilhermehns.vendas.domain.repository.UsuarioRepository;
import com.guilhermehns.vendas.exception.SenhaInvalidaException;
import com.guilhermehns.vendas.rest.dto.CadastroUsuarioDTO;
import com.guilhermehns.vendas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;
    private final UsuarioGrupoRepository usuarioGrupoRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public Usuario save(CadastroUsuarioDTO dto) {
        Usuario usuario = dto.getUsuario();
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        usuarioRepository.save(usuario);

        List<String> permissoes = dto.getPermissoes();
        List<UsuarioGrupo> listaUsuarioGrupo = permissoes.stream().map(p -> {
            Optional<Grupo> nomeGrupo = grupoRepository.findByNome(p);

            if (nomeGrupo.isPresent()) {
                Grupo grupo = nomeGrupo.get();
                return new UsuarioGrupo(usuario, grupo);
            }
            return null;
        }).filter(grupo -> grupo != null).collect(Collectors.toList());

        usuarioGrupoRepository.saveAll(listaUsuarioGrupo);

        return usuario;
    }

    public UserDetails autenticar(Usuario usuario){
        UserDetails user = loadUserByUserName(usuario.getLogin());
        if (passwordEncoder.matches(usuario.getSenha(), user.getPassword())) {
            return user;
        }
        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não econtrado na base de dados"));

        String[] roles = usuario.isAdmin() ?
                new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }
}
