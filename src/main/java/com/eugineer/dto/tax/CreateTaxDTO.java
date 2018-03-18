package com.eugineer.dto.tax;

import com.eugineer.model.ReportPeriods;

public class CreateTaxDTO {

    private ReportPeriods period;

    private double income;

    private double outOfRealizedIncomeWithoutVat;

    private boolean isHasMainWork;

    private boolean isBenefitPermitted;

    private boolean hasBenefitForSingle;

    private int childrenYounger18;

    private int disabledChildren;

    private int dependants;

    private double outcomeSumForInsurance;

    private double outcomeSumForEducation;

    private double outcomeSumForBuilding;

    private double outcomeSumForIndividualBusiness;



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

    public boolean ishasBenefitForSingle () {
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


}
