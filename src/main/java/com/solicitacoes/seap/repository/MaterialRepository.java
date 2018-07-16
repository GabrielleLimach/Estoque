package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.models.MaterialTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MaterialRepository extends JpaRepository <Material, Long> {

    List<Material> findByQuantidade(int quantidade);

    List<Material> findByFkmaterialtipo(MaterialTipo fkmaterialtipo);

}
