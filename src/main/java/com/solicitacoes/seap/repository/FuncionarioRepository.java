package com.solicitacoes.seap.repository;

import com.solicitacoes.seap.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long > {
}
