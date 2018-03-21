package com.eugineer.taxcalc.localization;

import org.springframework.stereotype.Component;

@Component
public class EnMessages implements Localization {
    public String TaxInfoNotFound() {
        return "No Tax result found";
    }

    @Override
    public String IllegalArguments () {
        return "Illegal arguments";
    }
}
