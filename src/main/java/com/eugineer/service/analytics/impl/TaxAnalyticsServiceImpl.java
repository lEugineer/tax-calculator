package com.eugineer.service.analytics.impl;

import com.eugineer.dto.tax.TaxResponseDTO;
import com.eugineer.exception.EntityNotFoundException;
import com.eugineer.localization.Localization;
import com.eugineer.repository.TaxRepository;
import com.eugineer.service.analytics.TaxAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TaxAnalyticsServiceImpl implements TaxAnalyticsService {

    @Autowired
    private TaxRepository repository;
    @Autowired
    private Localization messages;

    @Override
    public Page<TaxResponseDTO> getAll ( int page, int size) {
        return new PageImpl<>(
            repository.findAll( PageRequest.of( page, size ))
                .stream()
                .map( TaxResponseDTO::new )
                .collect( Collectors.toList())
        );
    }

    @Override
    public TaxResponseDTO findById ( Long id ) {
        if (!repository.existsById( id )) {
            throw new EntityNotFoundException( messages.TaxInfoNotFound() );
        }
        return new TaxResponseDTO( repository.findById( id ).get() );
    }
}
