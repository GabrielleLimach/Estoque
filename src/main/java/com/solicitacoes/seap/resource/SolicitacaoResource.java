package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.models.Solicitacao;
import com.solicitacoes.seap.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
