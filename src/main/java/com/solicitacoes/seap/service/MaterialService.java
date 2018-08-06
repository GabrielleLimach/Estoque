package com.solicitacoes.seap.service;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.repository.MaterialRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public Material atualizar(Long id, Material material) {
        Material materialSalvo = buscarMaterialPeloCodigo(id);

        BeanUtils.copyProperties(material, materialSalvo, "id");
        return materialRepository.save(materialSalvo);
    }

    //public void atualizarPropriedadeStatus(Long id, Boolean disponivel){
        //Material materialSalvo = buscarMaterialPeloCodigo(id);
        //materialSalvo.setFkmaterialstatus(disponivel);
        //materialRepository.save(materialSalvo);
    //}

    private Material buscarMaterialPeloCodigo(Long id) {
        Material materialSalvo = materialRepository.getOne(id);
        if (materialSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return materialSalvo;
    }
}
