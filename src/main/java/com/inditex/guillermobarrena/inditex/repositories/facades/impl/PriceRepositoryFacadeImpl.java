package com.inditex.guillermobarrena.inditex.repositories.facades.impl;

import com.inditex.guillermobarrena.inditex.domain.Price;
import com.inditex.guillermobarrena.inditex.repositories.entities.PricesEntity;
import com.inditex.guillermobarrena.inditex.repositories.facades.IAbstractRepositoryFacade;
import com.inditex.guillermobarrena.inditex.repositories.facades.IPriceRepositoryFacade;
import com.inditex.guillermobarrena.inditex.repositories.repositories.IPriceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceRepositoryFacadeImpl extends IAbstractRepositoryFacade<Price, PricesEntity> implements IPriceRepositoryFacade {
    @PersistenceContext
    protected EntityManager entityManager;

    private final IPriceRepository repository;

    public PriceRepositoryFacadeImpl(IPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Price convertEntityToDomain(PricesEntity entity) {
        if (entity == null) return null;
        return new Price(
                entity.getId(),
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getProductId(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency()
        );
    }

    @Override
    protected PricesEntity convertDomainToDomain(Price domain) {
        if (domain == null) return null;
        return new PricesEntity(
                domain.getId(),
                domain.getBrandId(),
                domain.getStartDate(),
                domain.getEndDate(),
                domain.getPriceList(),
                domain.getProductId(),
                domain.getPriority(),
                domain.getPrice(),
                domain.getCurrency()
        );
    }

    @Override
    public List<Price> findAll() {
        return this.repository
                .findAll()
                .stream()
                .map(this::convertEntityToDomain)
                .toList();
    }

    @Override
    public Price findFirst(Integer brandId, Integer productId, Timestamp startDate, Timestamp endDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PricesEntity> query = criteriaBuilder.createQuery(PricesEntity.class);
        Root<PricesEntity> root = query.from(PricesEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if (brandId != null) {
            predicates.add(criteriaBuilder.equal(root.get("brandId"), brandId));
        }

        if (productId != null) {
            predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
        }

        if (startDate != null) {
            predicates.add(criteriaBuilder.between(criteriaBuilder.literal(startDate),
                    root.<Timestamp>get("startDate"),
                    root.<Timestamp>get("endDate")));
        }

        if (endDate != null) {
            predicates.add(criteriaBuilder.between(criteriaBuilder.literal(startDate),
                    root.<Timestamp>get("startDate"),
                    root.<Timestamp>get("endDate")));
        }

        predicates.forEach(predicate -> query.where(criteriaBuilder.and(predicate)));

        query.orderBy(criteriaBuilder.desc(root.get("priority")));

        try {
            List<PricesEntity> list = entityManager.createQuery(query.select(root))
                    .getResultList();
            PricesEntity price = entityManager.createQuery(query.select(root))
                    .setMaxResults(1)
                    .getSingleResult();
            return convertEntityToDomain(price);
        } catch(NoResultException e) {
            return null;
        }
    }
}
