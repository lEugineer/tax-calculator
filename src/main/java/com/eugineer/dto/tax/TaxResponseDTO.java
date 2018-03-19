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

    public long getId () {
        return id;
    }

    public LocalDateTime getCreatedAt () {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt () {
        return updatedAt;
    }

    public ReportPeriods getPeriod () {
        return period;
    }

    public double getIncome () {
        return income;
    }

    public double getOutOfRealizedIncomeWithoutVat () {
        return outOfRealizedIncomeWithoutVat;
    }

    public boolean isHasMainWork () {
        return isHasMainWork;
    }

    public boolean isBenefitPermitted () {
        return isBenefitPermitted;
    }

    public boolean isHasBenefitForSingle () {
        return hasBenefitForSingle;
    }

    public int getChildrenYounger18 () {
        return childrenYounger18;
    }

    public int getDisabledChildren () {
        return disabledChildren;
    }

    public int getDependants () {
        return dependants;
    }

    public double getOutcomeSumForInsurance () {
        return outcomeSumForInsurance;
    }

    public double getOutcomeSumForEducation () {
        return outcomeSumForEducation;
    }

    public double getOutcomeSumForBuilding () {
        return outcomeSumForBuilding;
    }

    public double getOutcomeSumForIndividualBusiness () {
        return outcomeSumForIndividualBusiness;
    }

    public double getTaxToPay () {
        return taxToPay;
    }
}
