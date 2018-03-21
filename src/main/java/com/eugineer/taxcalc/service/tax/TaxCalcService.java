package com.eugineer.taxcalc.service.tax;

import com.eugineer.taxcalc.dto.tax.CreateTaxDTO;
import com.eugineer.taxcalc.dto.tax.TaxResponseDTO;
import org.springframework.data.domain.Page;

public interface TaxCalcService {
    Page<TaxResponseDTO> findAll ( int page, int size);
    TaxResponseDTO findById ( Long id);
    TaxResponseDTO create ( CreateTaxDTO dto);
}
