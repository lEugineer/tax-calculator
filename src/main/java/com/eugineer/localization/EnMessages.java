package com.eugineer.localization;

import org.springframework.stereotype.Component;

@Component
public class EnMessages implements Localization {
    public String TaxInfoNotFound() {
        return "No Tax result found";
    }
}
