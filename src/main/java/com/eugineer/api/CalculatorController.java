package com.eugineer.api;

import com.eugineer.dto.tax.CreateTaxDTO;
import com.eugineer.dto.tax.TaxResponseDTO;
import com.eugineer.service.tax.TaxCalcService;
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
