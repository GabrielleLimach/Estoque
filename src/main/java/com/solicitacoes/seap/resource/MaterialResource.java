package com.solicitacoes.seap.resource;

import com.solicitacoes.seap.event.RecursoCriadoEvent;
import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.models.MaterialTipo;
import com.solicitacoes.seap.repository.MaterialRepository;
import com.solicitacoes.seap.repository.filter.MaterialFilter;
import com.solicitacoes.seap.service.MaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/materiais")
@CrossOrigin("*")
public class MaterialResource {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MaterialService materialService;


    //insere um novo material, e retorna o material recem inserido
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Material> criar(@Valid @RequestBody Material material, HttpServletResponse response) {
        Material materialSalvo = materialRepository.save(material);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, materialSalvo.getIdmaterial()));

        return ResponseEntity.status(HttpStatus.CREATED).body(materialSalvo);
    }

    //retorna uma lista com todos os materiais
    @GetMapping
    private List<Material> pesquisar(MaterialFilter materialFilter) {

        return materialRepository.filtrar(materialFilter);
    }


    //retorna uma lista de materiais de acordo com a quantidade informada
    @GetMapping("/qde/{quantidade}")
    private List<Material> buscarPeloTipo(@PathVariable("quantidade") int id) {

        return materialRepository.findByQuantidade(id);
    }


    //retorna uma lista de materiais de acordo com o tipo informado
    @GetMapping("/tipo/{fkmaterialtipo}")
    private List<Material> buscarPeloTipo(@PathVariable("fkmaterialtipo") MaterialTipo id) {

        return materialRepository.findByFkmaterialtipo(id);

    }

    //retorna uma material especifico a partir do id (codigo) do material
    @GetMapping("/{idmaterial}")
    private ResponseEntity<Material> buscarPeloCodico(@PathVariable("idmaterial") Long id) {

        return ResponseEntity.ok(materialRepository.findById(id).get());

    }

    //deleta pelo id (codigo) o material informado
    @DeleteMapping("/{idmaterial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void remover(@PathVariable("idmaterial") Long id) {
        Material materialSalvo = materialRepository.findById(id).get();
        materialRepository.delete(materialSalvo);
    }


    //alterar os dados de um material ja cadastrado
    @PutMapping("/{idmaterial}")
    private ResponseEntity<Material> atualizar(@PathVariable("idmaterial") Long id, @Valid @RequestBody Material material) {
        Material materialSalvo = materialRepository.findById(id).get();
        BeanUtils.copyProperties(material, materialSalvo, "idmaterial");
        materialRepository.save(materialSalvo);
        return ResponseEntity.ok(materialSalvo);

    }
}
