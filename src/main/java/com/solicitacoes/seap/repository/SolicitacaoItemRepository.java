package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.SolicitacaoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository <SolicitacaoItem, Long> {
}
