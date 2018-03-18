package com.eugineer.service.tax;

import com.eugineer.dto.tax.CreateTaxDTO;
import com.eugineer.dto.tax.TaxResponseDTO;
import org.springframework.data.domain.Page;

public interface TaxCalcService {
    Page<TaxResponseDTO> getAll( int page, int size);
    TaxResponseDTO getById(Long id);
    TaxResponseDTO create(CreateTaxDTO dto);
}
