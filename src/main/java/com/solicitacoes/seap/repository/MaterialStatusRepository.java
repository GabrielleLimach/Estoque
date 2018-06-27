package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.MaterialStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<MaterialStatus, Long> {
}
