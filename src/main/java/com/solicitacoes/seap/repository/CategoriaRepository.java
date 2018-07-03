package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
}
