package com.eugineer.api;

import com.eugineer.dto.tax.CreateTaxDTO;
import com.eugineer.dto.tax.TaxResponseDTO;
import com.eugineer.service.tax.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tax-calculator")
public class CalculatorController {

    @Autowired
    private TaxCalcService taxService;

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void index() {
        System.out.println("Controller alive");
    }

    @PostMapping
    public ResponseEntity<TaxResponseDTO> calcTax (
            @RequestBody CreateTaxDTO createTaxDTO
    ) {
        TaxResponseDTO result = taxService.create( createTaxDTO );

        return ResponseEntity.ok( result );
    }

}
