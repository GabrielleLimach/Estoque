package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
