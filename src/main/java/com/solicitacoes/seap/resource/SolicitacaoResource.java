package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.Solicitacao;
import com.solicitacoes.seap.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
@CrossOrigin("*")
public class SolicitacaoResource {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    private List<Solicitacao> listar() {
        return solicitacaoRepository.findAll();

    }

    //insere um novo material, e retorna o material recem inserido
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Solicitacao> criar(@RequestBody Solicitacao solicitacao, HttpServletResponse response) {

        Solicitacao solicitacaoSalva = solicitacaoRepository.save(solicitacao);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, solicitacaoSalva.getIdsolicitacao()));

        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoSalva);
    }
}
