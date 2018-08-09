package com.solicitacoes.seap.repository.query;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.repository.filter.MaterialFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaterialRepositoryQuery {

    public Page<Material> filtrar(MaterialFilter materialFilter, Pageable pageable);

}
