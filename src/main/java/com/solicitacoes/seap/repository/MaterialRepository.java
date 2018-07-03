package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository <Material, Long> {
}
