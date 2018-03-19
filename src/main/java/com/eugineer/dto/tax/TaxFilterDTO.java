package com.eugineer.dto.tax;

import com.eugineer.model.ReportPeriods;

public class TaxFilterDTO {
    ReportPeriods period;

    Double incomeFrom;
    Double incomeTo;

    Double outOfRealizedIncomeWithoutVatFrom;
    Double outOfRealizedIncomeWithoutVatTo;

    Boolean isHasMainWork;

    Boolean isBenefitPermitted;

    Boolean hasBenefitForSingle;

    Integer childrenYounger18From;
    Integer childrenYounger18To;

    Integer disabledChildrenFrom;
    Integer disabledChildrenTo;

    Integer dependantsFrom;
    Integer dependantsTo;

    Double outcomeSumForInsuranceFrom;
    Double outcomeSumForInsuranceTo;

    Double outcomeSumForEducationFrom;
    Double outcomeSumForEducationTo;

    Double outcomeSumForBuildingFrom;
    Double outcomeSumForBuildingTo;

    Double outcomeSumForIndividualBusinessFrom;
    Double outcomeSumForIndividualBusinessTo;

    Double taxToPayFrom;
    Double taxToPayTo;

    public TaxFilterDTO(){}

    public ReportPeriods getPeriod () {
        return period;
    }

    public Double getIncomeFrom () {
        return incomeFrom;
    }

    public Double getIncomeTo () {
        return incomeTo;
    }

    public Double getOutOfRealizedIncomeWithoutVatFrom () {
        return outOfRealizedIncomeWithoutVatFrom;
    }

    public Double getOutOfRealizedIncomeWithoutVatTo () {
        return outOfRealizedIncomeWithoutVatTo;
    }

    public Boolean isHasMainWork () {
        return isHasMainWork;
    }

    public Boolean isBenefitPermitted () {
        return isBenefitPermitted;
    }

    public Boolean isHasBenefitForSingle () {
        return hasBenefitForSingle;
    }

    public Integer getChildrenYounger18From () {
        return childrenYounger18From;
    }

    public Integer getChildrenYounger18To () {
        return childrenYounger18To;
    }

    public Integer getDisabledChildrenFrom () {
        return disabledChildrenFrom;
    }

    public Integer getDisabledChildrenTo () {
        return disabledChildrenTo;
    }

    public Integer getDependantsFrom () {
        return dependantsFrom;
    }

    public Integer getDependantsTo () {
        return dependantsTo;
    }

    public Double getOutcomeSumForInsuranceFrom () {
        return outcomeSumForInsuranceFrom;
    }

    public Double getOutcomeSumForInsuranceTo () {
        return outcomeSumForInsuranceTo;
    }

    public Double getOutcomeSumForEducationFrom () {
        return outcomeSumForEducationFrom;
    }

    public Double getOutcomeSumForEducationTo () {
        return outcomeSumForEducationTo;
    }

    public Double getOutcomeSumForBuildingFrom () {
        return outcomeSumForBuildingFrom;
    }

    public Double getOutcomeSumForBuildingTo () {
        return outcomeSumForBuildingTo;
    }

    public Double getOutcomeSumForIndividualBusinessFrom () {
        return outcomeSumForIndividualBusinessFrom;
    }

    public Double getOutcomeSumForIndividualBusinessTo () {
        return outcomeSumForIndividualBusinessTo;
    }

    public Double getTaxToPayFrom () {
        return taxToPayFrom;
    }

    public Double getTaxToPayTo () {
        return taxToPayTo;
    }
}
