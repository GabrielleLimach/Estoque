package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.Cargo;
import com.solicitacoes.seap.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cargo")
@CrossOrigin("*")
public class CargoResource {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    private List<Cargo> listar() {
        return cargoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Cargo> criar(@Valid @RequestBody Cargo cargo, HttpServletResponse response) {
        Cargo cargoSalvo = cargoRepository.save(cargo);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, cargoSalvo.getIdcargo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(cargoSalvo);

    }

}
