package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.Categoria;
import com.solicitacoes.seap.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    private List<Categoria> listar() {
        return categoriaRepository.findAll();
    }


    @PostMapping
    private void criar(@RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/idcategoria")
                .buildAndExpand(categoriaSalva.getIdcategoria()).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
