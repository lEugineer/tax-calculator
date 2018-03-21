package com.eugineer.taxcalc.service.analytics.impl;

import com.eugineer.taxcalc.domain.TaxInfoEntity;
import com.eugineer.taxcalc.dto.tax.TaxFilterDTO;
import com.eugineer.taxcalc.dto.tax.TaxResponseDTO;
import com.eugineer.taxcalc.repository.TaxRepository;
import com.eugineer.taxcalc.service.analytics.TaxAnalyticsService;
import com.eugineer.taxcalc.service.tax.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
public class TaxAnalyticsServiceImpl implements TaxAnalyticsService {

    @Autowired
    private TaxRepository repository;
    @Autowired
    private TaxCalcService taxCalcService;

    @Override
    @Transactional(readOnly = true)
    public Page<TaxResponseDTO> findAll ( int page, int size) {
        return taxCalcService.findAll( page, size );
    }

    @Override
    @Transactional(readOnly = true)
    public TaxResponseDTO findById ( Long id ) {
        return taxCalcService.findById( id );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TaxResponseDTO> filter ( TaxFilterDTO dto, int page, int size ) {
        Page<TaxInfoEntity> filtered = repository.filter( dto, page, size );
        return new PageImpl<>(
                filtered
                    .stream()
                    .map( TaxResponseDTO::new )
                    .collect( Collectors.toList()),
                filtered.getPageable(),
                filtered.getTotalElements()
        );
    }
}
