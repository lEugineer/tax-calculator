package com.eugineer.taxcalc.api;

import com.eugineer.taxcalc.dto.tax.TaxFilterDTO;
import com.eugineer.taxcalc.dto.tax.TaxResponseDTO;
import com.eugineer.taxcalc.service.analytics.TaxAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController extends AbstractRestHandler {

    @Autowired
    private TaxAnalyticsService service;

    @GetMapping
    public ResponseEntity<Page<TaxResponseDTO>> getAll(
            @RequestParam(value="page", defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(value="size", defaultValue = DEFAULT_SIZE) int size
    ) {
        return ResponseEntity.ok(service.findAll( page, size ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxResponseDTO> getById( @PathVariable("id") Long id){
        return ResponseEntity.ok( service.findById( id ) );
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<TaxResponseDTO>> getFiltered (
            @RequestBody TaxFilterDTO filter,
            @RequestParam(value="page", defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(value="size", defaultValue = DEFAULT_SIZE) int size
    ) {
        return ResponseEntity.ok(service.filter( filter, page, size ));
    }
}
