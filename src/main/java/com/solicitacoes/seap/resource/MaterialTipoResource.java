package com.solicitacoes.seap.resource;


import com.solicitacoes.seap.models.MaterialTipo;
import com.solicitacoes.seap.repository.MaterialTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materiaistipo")
public class MaterialTipoResource {


        @Autowired
        private MaterialTipoRepository materialTipoRepository;

        @GetMapping
        private List<MaterialTipo> listar(){

            return materialTipoRepository.findAll();
        }
}
