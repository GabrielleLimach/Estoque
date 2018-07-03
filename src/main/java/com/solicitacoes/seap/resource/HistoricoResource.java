package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.models.Historico;
import com.solicitacoes.seap.repository.HistoricoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoResource {

    @Autowired
    private HistoricoRepository historicoRepository;

    @GetMapping
    private List<Historico> listar(){

        return historicoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Historico> criar (@RequestBody Historico historico, HttpServletResponse response){

    Historico historicosalvo = historicoRepository.save(historico);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idhistorico}")
            .buildAndExpand(historicosalvo.getIdhistorico()).toUri();
            response.setHeader("Location", uri.toASCIIString());
            return ResponseEntity.created(uri).body(historicosalvo);
    }

    @GetMapping("/idhistorico")
    private ResponseEntity<Historico> buscarPeloCodico(@PathVariable("idhistorico") Long id){
    return  ResponseEntity.ok(historicoRepository.findById(id).get());

    }

    @DeleteMapping("/idhistorico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void remover(@PathVariable("idmaterial")Long id){
        Historico historicoSalvo = historicoRepository.findById(id).get();
        historicoRepository.delete(historicoSalvo);
    }

    @PutMapping("/idhistorico")
    private ResponseEntity<Historico> atualizar(@PathVariable("idhistorico")Long id, @Valid @RequestBody Historico historico){
        Historico historicoSalvo = historicoRepository.findById(id).get();
        BeanUtils.copyProperties(historico, historicoSalvo, "idhistorico");
        historicoRepository.save(historicoSalvo);
        return  ResponseEntity.ok(historicoSalvo);

    }
}
