package com.eugineer.taxcalc.service.tax.impl;

import com.eugineer.taxcalc.domain.TaxInfoEntity;
import com.eugineer.taxcalc.dto.tax.CreateTaxDTO;
import com.eugineer.taxcalc.dto.tax.TaxResponseDTO;
import com.eugineer.taxcalc.exception.EntityNotFoundException;
import com.eugineer.taxcalc.localization.Localization;
import com.eugineer.taxcalc.model.ReportPeriods;
import com.eugineer.taxcalc.repository.TaxRepository;
import com.eugineer.taxcalc.service.tax.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
public class TaxCalcServiceImpl implements TaxCalcService {

    private final TaxRepository repository;
    private final Localization messages;

    @Autowired
    public TaxCalcServiceImpl ( TaxRepository repository, Localization messages ) {
        this.repository = repository;
        this.messages = messages;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TaxResponseDTO> findAll ( int page, int size) {
        Page<TaxInfoEntity> allTaxes = repository.findAll(PageRequest.of( page, size ));
        return new PageImpl<>(
                allTaxes.stream().map(TaxResponseDTO::new).collect(Collectors.toList()),
                PageRequest.of( page, size ),
                allTaxes.getTotalElements()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public TaxResponseDTO findById ( Long id ) {
        if (!repository.existsById( id )) {
            throw new EntityNotFoundException( messages.TaxInfoNotFound() );
        }

        return new TaxResponseDTO( repository.findById( id ).get() );
    }

    @Override
    public TaxResponseDTO create ( CreateTaxDTO dto ) {

        TaxInfoEntity entity = new TaxInfoEntity();
        entity.setPeriod( dto.getPeriod() );
        entity.setIncome( dto.getIncome() );
        entity.setOutOfRealizedIncomeWithoutVat( dto.getOutOfRealizedIncomeWithoutVat() );
        entity.setIsHasMainWork( dto.isHasMainWork() );
        entity.setIsBenefitPermitted( dto.isBenefitPermitted() );
        entity.setHasBenefitForSingle( dto.ishasBenefitForSingle() );
        entity.setChildrenYounger18( dto.getChildrenYounger18() );
        entity.setDisabledChildren( dto.getDisabledChildren() );
        entity.setDependants( dto.getDependants() );
        entity.setOutcomeSumForInsurance( dto.getOutcomeSumForInsurance() );
        entity.setOutcomeSumForEducation( dto.getOutcomeSumForEducation() );
        entity.setOutcomeSumForBuilding( dto.getOutcomeSumForBuilding() );
        entity.setOutcomeSumForIndividualBusiness( dto.getOutcomeSumForIndividualBusiness() );
        entity.setTaxToPay( getTaxAmount( dto ) );

        return new TaxResponseDTO(repository.save( entity ));
    }

    private double getTaxAmount(CreateTaxDTO dto) {
        ReportPeriods _1period = dto.getPeriod();

        double _2income = dto.getIncome();

        double _3outOfRealizedIncomeWithoutVat = dto.getOutOfRealizedIncomeWithoutVat();

        boolean _4isHasMainWork = dto.isHasMainWork();

        boolean _5isBenefitPermitted = dto.isBenefitPermitted();

        boolean _6hasBenefitForSingle = dto.ishasBenefitForSingle();

        int _7childrenYounger18 = dto.getChildrenYounger18();

        int _8disabledChildren = dto.getDisabledChildren();

        int _9dependants = dto.getDependants();

        double _10outcomeSumForInsurance = dto.getOutcomeSumForInsurance();

        double _11outcomeSumForEducation = dto.getOutcomeSumForEducation();

        double _12outcomeSumForBuilding = dto.getOutcomeSumForBuilding();

        double _13outcomeSumForIndividualBusiness = dto.getOutcomeSumForIndividualBusiness();

        double sum2and3 = _2income + _3outOfRealizedIncomeWithoutVat;
        if (_13outcomeSumForIndividualBusiness > sum2and3) {
            throw new IllegalArgumentException(messages.IllegalArguments());
        }

        if (_4isHasMainWork) {
            return (sum2and3 - _13outcomeSumForIndividualBusiness) * 0.16;
        }

        double s2;
        int limitForStep2_1 = 15_020_000;
        int limitForStep2_2 = 830_000;
        if (sum2and3 - _13outcomeSumForIndividualBusiness <= limitForStep2_1) {
            s2 = sum2and3 - (limitForStep2_2 * _1period.getMonths());
        } else {
            s2 = sum2and3;
        }
        if (s2 < 0) s2 = 0;

        double s3;
        int limitForStep3 = 1_170_000;
        if (_5isBenefitPermitted) {
            s3 = s2 - (limitForStep3 * _1period.getMonths());
        } else {
            s3 = s2;
        }
        if (s3 < 0) s3 = 0;


        //TODO Invalid math?
        /*
            not all cases of _6 _7 _8 _9 covered
            s4 is 0 and the result is 0 as a result
        */
        double s4 = 0;
        int limitForStep4_1 = 460_000;
        int limitForStep4_2 = 240_000;
        if (_6hasBenefitForSingle
        && _7childrenYounger18 > 0
        && _8disabledChildren <= _7childrenYounger18
        && _9dependants > 0) {
            s4 = s3 - _1period.getMonths() * limitForStep4_1 * (_7childrenYounger18 + _9dependants);
        } else
        if (!_6hasBenefitForSingle
        && _7childrenYounger18 == 1
        && _8disabledChildren == 0
        && _9dependants > 0) {
            s4 = s3 - _1period.getMonths() * limitForStep4_2 * (_7childrenYounger18 + _9dependants);
        } else
        if (!_6hasBenefitForSingle
        && _7childrenYounger18 == 1
        && _8disabledChildren == 1
        && _9dependants > 0) {
            s4 = s3 - _1period.getMonths() * (_7childrenYounger18 * limitForStep4_1 + _9dependants * limitForStep4_2);
        } else
        if (!_6hasBenefitForSingle
        && _7childrenYounger18 > 1
        && _8disabledChildren <= _7childrenYounger18
        && _9dependants > 0) {
            s4 = s3 - _1period.getMonths() * limitForStep4_1 * (_7childrenYounger18 + _9dependants);
        }
        if (s4 < 0) s4 = 0;

        double s5 = 0;
        int limitForStep5 = 16_000_000;
        if (_10outcomeSumForInsurance <= limitForStep5) {
            s5 = s4 - _10outcomeSumForInsurance;
        } else {
            s5 = s4 - limitForStep5;
        }
        if (s5 < 0) s5 = 0;

        double s6 = s5 - (_11outcomeSumForEducation + _12outcomeSumForBuilding + _13outcomeSumForIndividualBusiness);
        if (s6 < 0) s6 = 0;

        double taxPercent = 0.16;
        return s6 * taxPercent;
    }
}
