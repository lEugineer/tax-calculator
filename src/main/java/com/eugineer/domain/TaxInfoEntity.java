package com.eugineer.domain;

import com.eugineer.model.ReportPeriods;

import javax.persistence.*;

@Entity
@Table(name = "calculated_taxes")
public class TaxInfoEntity extends AbstractEntity {

    @Column
    @Enumerated(EnumType.STRING)
    ReportPeriods period;

    @Column
    double income;

    @Column
    double outOfRealizedIncomeWithoutVat;

    @Column
    boolean isHasMainWork;

    @Column
    boolean isBenefitPermitted;

    @Column
    boolean hasBenefitForSingle;

    @Column
    int childrenYounger18;

    @Column
    int disabledChildren;

    @Column
    int dependants;

    @Column
    double outcomeSumForInsurance;

    @Column
    double outcomeSumForEducation;

    @Column
    double outcomeSumForBuilding;

    @Column
    double outcomeSumForIndividualBusiness;

    @Column
    double taxToPay;


    public ReportPeriods getPeriod () {
        return period;
    }

    public TaxInfoEntity setPeriod ( ReportPeriods period ) {
        this.period = period;
        return this;
    }

    public double getIncome () {
        return income;
    }

    public TaxInfoEntity setIncome ( double income ) {
        this.income = income;
        return this;
    }

    public double getOutOfRealizedIncomeWithoutVat () {
        return outOfRealizedIncomeWithoutVat;
    }

    public TaxInfoEntity setOutOfRealizedIncomeWithoutVat ( double outOfRealizedIncomeWithoutVat ) {
        this.outOfRealizedIncomeWithoutVat = outOfRealizedIncomeWithoutVat;
        return this;
    }

    public boolean isHasMainWork () {
        return isHasMainWork;
    }

    public TaxInfoEntity setIsHasMainWork ( boolean isHasMainWork ) {
        this.isHasMainWork = isHasMainWork;
        return this;
    }

    public boolean isBenefitPermitted () {
        return isBenefitPermitted;
    }

    public TaxInfoEntity setIsBenefitPermitted ( boolean isBenefitPermitted ) {
        this.isBenefitPermitted = isBenefitPermitted;
        return this;
    }

    public boolean isHasBenefitForSingle () {
        return hasBenefitForSingle;
    }

    public TaxInfoEntity setHasBenefitForSingle ( boolean hasBenefitForSingle ) {
        this.hasBenefitForSingle = hasBenefitForSingle;
        return this;
    }

    public int getChildrenYounger18 () {
        return childrenYounger18;
    }

    public TaxInfoEntity setChildrenYounger18 ( int childrenYounger18 ) {
        this.childrenYounger18 = childrenYounger18;
        return this;
    }

    public int getDisabledChildren () {
        return disabledChildren;
    }

    public TaxInfoEntity setDisabledChildren ( int disabledChildren ) {
        this.disabledChildren = disabledChildren;
        return this;
    }

    public int getDependants () {
        return dependants;
    }

    public TaxInfoEntity setDependants ( int dependants ) {
        this.dependants = dependants;
        return this;
    }

    public double getOutcomeSumForInsurance () {
        return outcomeSumForInsurance;
    }

    public TaxInfoEntity setOutcomeSumForInsurance ( double outcomeSumForInsurance ) {
        this.outcomeSumForInsurance = outcomeSumForInsurance;
        return this;
    }

    public double getOutcomeSumForEducation () {
        return outcomeSumForEducation;
    }

    public TaxInfoEntity setOutcomeSumForEducation ( double outcomeSumForEducation ) {
        this.outcomeSumForEducation = outcomeSumForEducation;
        return this;
    }

    public double getOutcomeSumForBuilding () {
        return outcomeSumForBuilding;
    }

    public TaxInfoEntity setOutcomeSumForBuilding ( double outcomeSumForBuilding ) {
        this.outcomeSumForBuilding = outcomeSumForBuilding;
        return this;
    }

    public double getOutcomeSumForIndividualBusiness () {
        return outcomeSumForIndividualBusiness;
    }

    public TaxInfoEntity setOutcomeSumForIndividualBusiness ( double outcomeSumForIndividualBusiness ) {
        this.outcomeSumForIndividualBusiness = outcomeSumForIndividualBusiness;
        return this;
    }

    public double getTaxToPay () {
        return taxToPay;
    }

    public TaxInfoEntity setTaxToPay ( double taxToPay ) {
        this.taxToPay = taxToPay;
        return this;
    }

    //    TODO toString
    @Override
    public String toString () {
        return "RequestParams{}";
    }
}
