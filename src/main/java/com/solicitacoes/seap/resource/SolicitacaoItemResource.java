package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.SolicitacaoItem;
import com.solicitacoes.seap.repository.SolicitacaoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/solicitacaoitens")
@CrossOrigin("*")
public class SolicitacaoItemResource {

    @Autowired
    private SolicitacaoItemRepository solicitacaoItemRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    private List<SolicitacaoItem> listar() {
        return solicitacaoItemRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<SolicitacaoItem> criar(@Valid @RequestBody SolicitacaoItem solicitacaoItem, HttpServletResponse response) {
        SolicitacaoItem solicitacaoItem1 = solicitacaoItemRepository.save(solicitacaoItem);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, solicitacaoItem.getIdsolicitacaoitem()));

        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoItem);
    }
}
