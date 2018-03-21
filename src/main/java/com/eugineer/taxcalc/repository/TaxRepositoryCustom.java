package com.eugineer.taxcalc.repository;

import com.eugineer.taxcalc.domain.TaxInfoEntity;
import com.eugineer.taxcalc.dto.tax.TaxFilterDTO;
import org.springframework.data.domain.Page;

public interface TaxRepositoryCustom {
    Page<TaxInfoEntity> filter ( TaxFilterDTO dto, int page, int size );
}