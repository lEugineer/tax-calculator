package com.eugineer.taxcalc.repository;

import com.eugineer.taxcalc.domain.TaxInfoEntity;
import com.eugineer.taxcalc.dto.tax.TaxFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxRepositoryCustomImpl implements TaxRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<TaxInfoEntity> filter ( TaxFilterDTO dto, int page, int size ) {
        if (size <= 0) size = 25;
        if (page < 0) page = 1;

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select( criteriaBuilder.count(countQuery.from(TaxInfoEntity.class)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        if (count == 0) {
            return new PageImpl<>(new ArrayList<>(), PageRequest.of(page, size), count);
        }


        CriteriaQuery<TaxInfoEntity> query = criteriaBuilder.createQuery( TaxInfoEntity.class );

        Root<TaxInfoEntity> root = query.from( TaxInfoEntity.class );

        Predicate predicate = criteriaBuilder.conjunction();

        if (dto.getPeriod() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.equal( root.get( "period" ), dto.getPeriod() ) );
        }

        if (dto.getChildrenYounger18From() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "childrenYounger18" ), dto.getChildrenYounger18From() ) );
        }
        if (dto.getChildrenYounger18To() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "childrenYounger18" ), dto.getChildrenYounger18To() ) );
        }

        if (dto.getDependantsFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "dependants" ), dto.getDependantsFrom() ) );
        }
        if (dto.getDependantsTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "dependants" ), dto.getDependantsTo() ) );
        }

        if (dto.getDisabledChildrenFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "disabledChildren" ), dto.getDisabledChildrenFrom() ) );
        }
        if (dto.getDisabledChildrenTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "disabledChildren" ), dto.getDisabledChildrenTo() ) );
        }

        if (dto.getIncomeFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "income" ), dto.getIncomeFrom() ) );
        }
        if (dto.getIncomeTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "income" ), dto.getIncomeTo() ) );
        }

        if (dto.getOutcomeSumForBuildingFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "outcomeSumForBuilding" ), dto.getOutcomeSumForBuildingFrom() ) );
        }
        if (dto.getOutcomeSumForBuildingTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "outcomeSumForBuilding" ), dto.getOutcomeSumForBuildingTo() ) );
        }

        if (dto.getOutcomeSumForEducationFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "outcomeSumForEducation" ), dto.getOutcomeSumForEducationFrom() ) );
        }
        if (dto.getOutcomeSumForEducationTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "outcomeSumForEducation" ), dto.getOutcomeSumForEducationTo() ) );
        }

        if (dto.getOutcomeSumForIndividualBusinessFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "outcomeSumForIndividualBusiness" ), dto.getOutcomeSumForIndividualBusinessFrom() ) );
        }
        if (dto.getOutcomeSumForIndividualBusinessTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "outcomeSumForIndividualBusiness" ), dto.getOutcomeSumForIndividualBusinessTo() ) );
        }

        if (dto.getOutcomeSumForInsuranceFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "outcomeSumForInsurance" ), dto.getOutcomeSumForInsuranceFrom() ) );
        }
        if (dto.getOutcomeSumForInsuranceTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "outcomeSumForInsurance" ), dto.getOutcomeSumForInsuranceTo() ) );
        }

        if (dto.getOutOfRealizedIncomeWithoutVatFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "outOfRealizedIncomeWithoutVat" ), dto.getOutOfRealizedIncomeWithoutVatFrom() ) );
        }
        if (dto.getOutOfRealizedIncomeWithoutVatTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "outOfRealizedIncomeWithoutVat" ), dto.getOutOfRealizedIncomeWithoutVatTo() ) );
        }

        if (dto.getTaxToPayFrom() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.greaterThanOrEqualTo( root.get( "taxToPay" ), dto.getTaxToPayFrom() ) );
        }
        if (dto.getTaxToPayTo() != null) {
            predicate = criteriaBuilder.and( predicate,
                    criteriaBuilder.lessThanOrEqualTo( root.get( "taxToPay" ), dto.getTaxToPayTo() ) );
        }

        query.where( predicate );

        List<TaxInfoEntity> result = entityManager.createQuery( query )
                .setFirstResult( (page - 1) * size )
                .setMaxResults( size )
                .getResultList();

        return new PageImpl<>( result, PageRequest.of(page, size), count );
    }
}
