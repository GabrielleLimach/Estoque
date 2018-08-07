package com.solicitacoes.seap.repository.query;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.repository.filter.MaterialFilter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaterialRepositoryImpl implements MaterialRepositoryQuery {

    @PersistenceContext
    private EntityManager maneger;

    @Override
    public List<Material> filtrar(MaterialFilter materialFilter) {
        CriteriaBuilder builder = maneger.getCriteriaBuilder();
        CriteriaQuery<Material> criteria = builder.createQuery(Material.class);
        Root<Material> root = criteria.from(Material.class);

        Predicate[] predicates = criarRestricoes(materialFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Material> query = maneger.createQuery(criteria);
        return query.getResultList();
    }

    public Predicate[] criarRestricoes(MaterialFilter materialFilter, CriteriaBuilder builder, Root<Material> root){
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(materialFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")), "%" + materialFilter.getNome().toLowerCase() + "%"));

        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
