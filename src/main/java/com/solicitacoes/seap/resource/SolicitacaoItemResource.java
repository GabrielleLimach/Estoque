package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.SolicitacaoItem;
import com.solicitacoes.seap.repository.SolicitacaoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitacaoitens")
@CrossOrigin("*")
public class SolicitacaoItemResource {

    @Autowired
    private SolicitacaoItemRepository solicitacaoItemRepository;

    @GetMapping
    private List<SolicitacaoItem> listar(){
        return solicitacaoItemRepository.findAll();

    }
}
