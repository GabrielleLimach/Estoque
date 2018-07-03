package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
