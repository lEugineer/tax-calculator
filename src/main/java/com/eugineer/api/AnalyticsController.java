package com.eugineer.api;

import com.eugineer.dto.tax.TaxResponseDTO;
import com.eugineer.service.tax.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private TaxCalcService service;

    @GetMapping
    public ResponseEntity<Page<TaxResponseDTO>> getAll(
            @RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "25") int size
    ) {
        return ResponseEntity.ok(service.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxResponseDTO> getById( @PathVariable("id") Long id){
        return ResponseEntity.ok( service.getById( id ) );
    }
}
