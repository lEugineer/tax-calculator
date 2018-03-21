package com.eugineer.taxcalc.api;

import com.eugineer.taxcalc.dto.tax.CreateTaxDTO;
import com.eugineer.taxcalc.dto.tax.TaxResponseDTO;
import com.eugineer.taxcalc.service.tax.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax-calculator")
public class CalculatorController extends AbstractRestHandler {

    @Autowired
    private TaxCalcService taxService;

    @PostMapping
    public ResponseEntity<TaxResponseDTO> calcTax (
            @RequestBody CreateTaxDTO createTaxDTO
    ) {
        TaxResponseDTO result = taxService.create( createTaxDTO );

        return ResponseEntity.ok( result );
    }

}
