package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.Funcionario;
import com.solicitacoes.seap.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    private List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    private void criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/idfuncionario").buildAndExpand().toUri();


    }
}
