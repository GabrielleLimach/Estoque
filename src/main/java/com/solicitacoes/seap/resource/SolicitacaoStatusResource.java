package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.SolicitacaoStatus;
import com.solicitacoes.seap.repository.SolicitacaoStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/solicitacaostatus")
@CrossOrigin("*")
public class SolicitacaoStatusResource {

    @Autowired
    private SolicitacaoStatusRepository solicitacaoStatusRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    private List<SolicitacaoStatus> listar() {
        return solicitacaoStatusRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<SolicitacaoStatus> criar(@Valid @RequestBody SolicitacaoStatus solicitacaoStatus, HttpServletResponse response) {
        SolicitacaoStatus solicitacaoStatusSalvo = solicitacaoStatusRepository.save(solicitacaoStatus);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, solicitacaoStatus.getIdsolicitacaostatus()));

        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoStatus);
    }

}
