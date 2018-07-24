package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.MaterialStatus;
import com.solicitacoes.seap.repository.MaterialStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materialstatus")
@CrossOrigin("*")
public class MaterialStatusResource {

    @Autowired
    private MaterialStatusRepository materialStatusRepository;

    @GetMapping
    private List<MaterialStatus> listar() {
        return materialStatusRepository.findAll();

    }
}