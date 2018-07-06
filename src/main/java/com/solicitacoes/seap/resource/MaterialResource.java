package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.repository.MaterialRepository;
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
@RequestMapping("/materiais")
@CrossOrigin("*")
public class MaterialResource {

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    private List<Material> listar(){

        return materialRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Material> criar (@RequestBody Material material, HttpServletResponse response){

        Material materialSalvo = materialRepository.save(material);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idmaterial}")
                .buildAndExpand(materialSalvo.getIdmaterial()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(materialSalvo);
    }

    @GetMapping("/{idmaterial}")
    private ResponseEntity<Material> buscarPeloCodico(@PathVariable("idmaterial") Long id){
        return  ResponseEntity.ok(materialRepository.findById(id).get());

    }

    @DeleteMapping("/{idmaterial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void remover(@PathVariable("idmaterial")Long id){
        Material materialSalvo = materialRepository.findById(id).get();
        materialRepository.delete(materialSalvo);
    }

    @PutMapping("/{idmaterial}")
    private ResponseEntity<Material> atualizar(@PathVariable("idmaterial")Long id, @Valid @RequestBody Material material){
        Material materialSalvo = materialRepository.findById(id).get();
        BeanUtils.copyProperties(material, materialSalvo, "idmaterial");
        materialRepository.save(materialSalvo);
        return  ResponseEntity.ok(materialSalvo);

    }
}
