package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Material;
<<<<<<< HEAD
import com.solicitacoes.seap.models.MaterialTipo;
=======
import com.solicitacoes.seap.resource.HistoricoResource;
>>>>>>> cdb7df224fde77ab9c4caf38a8a206bb0b0cd47a
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MaterialRepository extends JpaRepository <Material, Long> {

    List<Material> findByQuantidade(int quantidade);

    List<Material> findByFkmaterialtipo(MaterialTipo fkmaterialtipo);

}
