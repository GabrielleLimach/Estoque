package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.models.MaterialTipo;
import com.solicitacoes.seap.repository.query.MaterialRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long>, MaterialRepositoryQuery {

    List<Material> findByQuantidade(int quantidade);

    List<Material> findByFkmaterialtipo(MaterialTipo fkmaterialtipo);
}
