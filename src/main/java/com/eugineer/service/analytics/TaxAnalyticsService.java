package com.eugineer.service.analytics;

import com.eugineer.dto.tax.TaxResponseDTO;
import org.springframework.data.domain.Page;

public interface TaxAnalyticsService {
    Page<TaxResponseDTO> getAll( int page, int size);
    TaxResponseDTO findById(Long id);
}
