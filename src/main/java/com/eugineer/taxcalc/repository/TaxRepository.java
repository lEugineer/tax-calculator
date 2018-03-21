package com.eugineer.taxcalc.repository;

import com.eugineer.taxcalc.domain.TaxInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository
        extends BaseRepository<TaxInfoEntity>, TaxRepositoryCustom {

}
