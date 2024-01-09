package com.guilhermehns.vendas.rest.controller;

import com.guilhermehns.vendas.domain.entity.Grupo;
import com.guilhermehns.vendas.domain.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoRepository repository;

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(CREATED)
    public Grupo save(@RequestBody Grupo grupo){
        return repository.save(grupo);
    }

    @GetMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public List<Grupo> listar(){
        return repository.findAll();
    }
}
