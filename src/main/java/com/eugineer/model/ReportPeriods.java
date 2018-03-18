package com.eugineer.model;

public enum ReportPeriods {
    Quartal(3),
    HalfYear(6),
    NineMonth(9),
    Year(12);

    private int months;

    ReportPeriods ( int months ) {
        this.months = months;
    }


    public int getMonths () {
        return months;
    }
}
