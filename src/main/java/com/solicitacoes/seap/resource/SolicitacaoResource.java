package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.models.Solicitacao;
import com.solicitacoes.seap.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
@CrossOrigin("*")
public class SolicitacaoResource {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @GetMapping
    private List<Solicitacao> listar(){
        return solicitacaoRepository.findAll();

    }
    //insere um novo material, e retorna o material recem inserido
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Solicitacao> criar(@RequestBody Solicitacao solicitacao, HttpServletResponse response) {

        Solicitacao solicitacaoSalva = solicitacaoRepository.save(solicitacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idsolicitacao}")
                .buildAndExpand(solicitacaoSalva.getIdsolicitacao()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(solicitacaoSalva);
    }
}
