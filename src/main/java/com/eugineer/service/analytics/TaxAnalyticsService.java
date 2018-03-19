package com.eugineer.service.analytics;

import com.eugineer.dto.tax.TaxFilterDTO;
import com.eugineer.dto.tax.TaxResponseDTO;
import org.springframework.data.domain.Page;

public interface TaxAnalyticsService {
    Page<TaxResponseDTO> findAll ( int page, int size);
    TaxResponseDTO findById ( Long id);
    Page<TaxResponseDTO> filter ( TaxFilterDTO dto, int page, int size);
}
