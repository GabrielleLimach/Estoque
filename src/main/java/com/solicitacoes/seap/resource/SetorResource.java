package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.Setor;
import com.solicitacoes.seap.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/setor")
@CrossOrigin("*")
public class SetorResource {

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    private List<Setor> listar() {
        return setorRepository.findAll();
    }

    @PostMapping
    private ResponseEntity<Setor> criar(@Valid @RequestBody Setor setor, HttpServletResponse response) {
        Setor setorSalvo = setorRepository.save(setor);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, setorSalvo.getIdsetor()));

        return ResponseEntity.status(HttpStatus.CREATED).body(setorSalvo);
    }
}
