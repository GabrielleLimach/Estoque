package com.solicitacoes.seap.repository.query;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.repository.filter.MaterialFilter;

import java.util.List;

public interface MaterialRepositoryQuery {

    public List<Material> filtrar(MaterialFilter materialFilter);

}
