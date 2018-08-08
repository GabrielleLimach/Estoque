package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.MaterialStatus;
import com.solicitacoes.seap.repository.MaterialStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/materialstatus")
@CrossOrigin("*")
public class MaterialStatusResource {

    @Autowired
    private MaterialStatusRepository materialStatusRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    private List<MaterialStatus> listar() {
        return materialStatusRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<MaterialStatus> criar(@Valid @RequestBody MaterialStatus materialStatus, HttpServletResponse response) {
        MaterialStatus materialStatusSalvo = materialStatusRepository.save(materialStatus);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, materialStatusSalvo.getIdmaterialstatus()));

        return ResponseEntity.status(HttpStatus.CREATED).body(materialStatusSalvo);
    }

}