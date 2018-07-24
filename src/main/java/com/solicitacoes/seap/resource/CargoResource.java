package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.Cargo;
import com.solicitacoes.seap.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoResource {

    @Autowired
    private CargoRepository cargoRepository;


    @GetMapping
    private List<Cargo> listar() {
        return cargoRepository.findAll();
    }

    @PostMapping
    private void criar(@RequestBody Cargo cargo, HttpServletResponse response) {
        Cargo cargoSalvo = cargoRepository.save(cargo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/idcargo")
                .buildAndExpand(cargoSalvo.getIdcargo()).toUri();
        response.setHeader("Location", uri.toASCIIString());

    }
}
