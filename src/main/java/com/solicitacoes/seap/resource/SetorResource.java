package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.models.Setor;
import com.solicitacoes.seap.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/setor")
public class SetorResource {

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    private List<Setor> listar() {
        return setorRepository.findAll();
    }

    @PostMapping
    private void criar(@RequestBody Setor setor, HttpServletResponse response) {
        Setor setorSalvo = setorRepository.save(setor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idsetor}")
                .buildAndExpand(setorSalvo.getIdsetor()).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
