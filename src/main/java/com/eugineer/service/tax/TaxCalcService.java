package com.eugineer.service.tax;

import com.eugineer.dto.tax.CreateTaxDTO;
import com.eugineer.dto.tax.TaxResponseDTO;
import org.springframework.data.domain.Page;

public interface TaxCalcService {
    Page<TaxResponseDTO> findAll ( int page, int size);
    TaxResponseDTO findById ( Long id);
    TaxResponseDTO create ( CreateTaxDTO dto);
}
