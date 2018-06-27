package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.MaterialTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<MaterialTipo, Long> {
}
