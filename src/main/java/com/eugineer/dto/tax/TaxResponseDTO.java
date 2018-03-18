package com.eugineer.dto.tax;

import com.eugineer.config.CustomLocalDateTimeSerializer;
import com.eugineer.domain.TaxInfoEntity;
import com.eugineer.model.ReportPeriods;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

public class TaxResponseDTO {
    long id;

    @JsonSerialize(using= CustomLocalDateTimeSerializer.class)
    LocalDateTime createdAt;

    @JsonSerialize(using= CustomLocalDateTimeSerializer.class)
    LocalDateTime updatedAt;

    ReportPeriods period;

    double income;

    double outOfRealizedIncomeWithoutVat;

    boolean isHasMainWork;

    boolean isBenefitPermitted;

    boolean hasBenefitForSingle;

    int childrenYounger18;

    int disabledChildren;

    int dependants;

    double outcomeSumForInsurance;

    double outcomeSumForEducation;

    double outcomeSumForBuilding;

    double outcomeSumForIndividualBusiness;

    double taxToPay;

    public TaxResponseDTO ( TaxInfoEntity tax ) {
        id = tax.getId();
        createdAt = tax.getCreatedAt();
        updatedAt = tax.getUpdatedAt();
        period = tax.getPeriod();
        income = tax.getIncome();
        outOfRealizedIncomeWithoutVat = tax.getOutOfRealizedIncomeWithoutVat();
        isHasMainWork = tax.isHasMainWork();
        isBenefitPermitted = tax.isBenefitPermitted();
        hasBenefitForSingle = tax.isHasBenefitForSingle();
        childrenYounger18 = tax.getChildrenYounger18();
        disabledChildren = tax.getDisabledChildren();
        dependants = tax.getDependants();
        outcomeSumForInsurance = tax.getOutcomeSumForInsurance();
        outcomeSumForEducation = tax.getOutcomeSumForEducation();
        outcomeSumForBuilding = tax.getOutcomeSumForBuilding();
        outcomeSumForIndividualBusiness = tax.getOutcomeSumForIndividualBusiness();
        taxToPay = tax.getTaxToPay();
    }
}
