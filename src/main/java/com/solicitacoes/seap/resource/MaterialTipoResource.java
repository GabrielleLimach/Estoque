package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.MaterialTipo;
import com.solicitacoes.seap.repository.MaterialTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/materiaistipo")
@CrossOrigin("*")
public class MaterialTipoResource {


    @Autowired
    private MaterialTipoRepository materialTipoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    private List<MaterialTipo> listar() {

        return materialTipoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<MaterialTipo> criar(@Valid @RequestBody MaterialTipo materialTipo, HttpServletResponse response) {
        MaterialTipo materialTipoSalvo = materialTipoRepository.save(materialTipo);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, materialTipoSalvo.getIdmaterialtipo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(materialTipoSalvo);

    }
}


