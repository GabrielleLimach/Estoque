package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository <Solicitacao, Long> {
}
