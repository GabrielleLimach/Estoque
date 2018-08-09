package com.solicitacoes.seap.repository.query;

import com.solicitacoes.seap.models.Material;
import com.solicitacoes.seap.models.Material_;
import com.solicitacoes.seap.repository.filter.MaterialFilter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class MaterialRepositoryImpl implements MaterialRepositoryQuery {

    @PersistenceContext
    private EntityManager maneger;

    @Override
    public Page<Material> filtrar(MaterialFilter materialFilter, Pageable pageable) {
        CriteriaBuilder builder = maneger.getCriteriaBuilder();
        CriteriaQuery<Material> criteria = builder.createQuery(Material.class);
        Root<Material> root = criteria.from(Material.class);

        Predicate[] predicates = criarRestricoes(materialFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Material> query = maneger.createQuery(criteria);
        adcionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(materialFilter));
    }


    public Predicate[] criarRestricoes(MaterialFilter materialFilter, CriteriaBuilder builder, Root<Material> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(materialFilter.getNome())) {
            predicates.add(builder.like(root.get(Material_.nome), "%" + materialFilter.getNome().toLowerCase() + "%"));

        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adcionarRestricoesDePaginacao(TypedQuery<Material> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);

    }

    private Long total(MaterialFilter materialFilter){
        CriteriaBuilder builder = maneger.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Material> root = criteria.from(Material.class);

        Predicate[] predicates = criarRestricoes(materialFilter, builder, root);
        criteria.where(predicates);
        criteria.select(builder.count(root));
        return maneger.createQuery(criteria).getSingleResult();
    }

}
