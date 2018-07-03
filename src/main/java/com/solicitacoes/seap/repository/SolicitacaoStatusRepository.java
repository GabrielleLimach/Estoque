package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.SolicitacaoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoStatusRepository extends JpaRepository <SolicitacaoStatus, Long> {
}
