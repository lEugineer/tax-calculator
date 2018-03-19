package com.eugineer.repository;

import com.eugineer.domain.TaxInfoEntity;
import com.eugineer.dto.tax.TaxFilterDTO;
import org.springframework.data.domain.Page;

public interface TaxRepositoryCustom {
    Page<TaxInfoEntity> filter ( TaxFilterDTO dto, int page, int size );
}