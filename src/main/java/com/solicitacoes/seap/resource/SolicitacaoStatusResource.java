package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.SolicitacaoStatus;
import com.solicitacoes.seap.repository.SolicitacaoStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitacaostatus")
@CrossOrigin("*")
public class SolicitacaoStatusResource {

    @Autowired
    private SolicitacaoStatusRepository solicitacaoStatusRepository;

    @GetMapping
    private List<SolicitacaoStatus> listar(){
        return solicitacaoStatusRepository.findAll();
    }


}
