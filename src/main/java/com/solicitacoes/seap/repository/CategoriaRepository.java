package com.solicitacoes.seap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solicitacoes.seap.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
